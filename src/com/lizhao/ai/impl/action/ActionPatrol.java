package com.lizhao.ai.impl.action;

import com.lizhao.ai.common.EStatus;
import com.lizhao.ai.abs.BaseAction;
import com.lizhao.ai.ifs.IBehaviour;

public class ActionPatrol extends BaseAction {

  @Override
  public EStatus update() {
    System.out.println("ActionPatrol 巡逻");


    return EStatus.Success;
  }

  @Override
  public void addChild(IBehaviour child) {
  }
}
