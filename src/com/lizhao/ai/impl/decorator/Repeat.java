package com.lizhao.ai.impl.decorator;

import com.lizhao.ai.abs.BaseDecorator;
import com.lizhao.ai.common.EStatus;
import com.lizhao.ai.ifs.IBehaviour;

public class Repeat extends BaseDecorator {

  private int limited = 3;
  int count = 0;

  @Override
  public EStatus update() {
    while (true) {
      child.tick();
      switch (child.getStatus()) {
        case Running:
          return EStatus.Success;
        case Failure:
          return EStatus.Failure;
        default:
          break;
      }
      if (++count == limited)
        return EStatus.Success;
      child.reset();
    }
  }

  @Override
  public void addChild(IBehaviour child) {
    super.addChild(child);
  }
}
