package com.lizhao.ai.impl.composite;

import com.lizhao.ai.common.EStatus;
import com.lizhao.ai.abs.BaseComposite;
import com.lizhao.ai.ifs.IBehaviour;
import com.lizhao.ai.ifs.composite.ISequence;

import java.util.Iterator;

public class SelectorImpl extends BaseComposite implements ISequence {

  private IBehaviour currChild;

  @Override
  public EStatus update() {
    Iterator<IBehaviour> iterator = getChildren().iterator();
    if (iterator.hasNext()) {
      while (true) {
        currChild = iterator.next();
        EStatus s = currChild.tick();
        //如果执行成功了就继续执行，否则返回
        if (s != EStatus.Failure)
          return s;
        if (!iterator.hasNext())
          return EStatus.Failure;
      }
    }
    return EStatus.Invalid;  //循环意外终止
  }
}
