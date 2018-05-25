package com.lizhao.ai.abs;

import com.lizhao.ai.ifs.IBehaviour;
import com.lizhao.ai.ifs.IComposite;
import com.lizhao.ai.ifs.IDecorator;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDecorator extends BaseBehavior implements IDecorator {

  protected IBehaviour child;//装饰器只会有一个子节点

  @Override
  public void addChild(IBehaviour child) {
    this.child = child;
  }

}
