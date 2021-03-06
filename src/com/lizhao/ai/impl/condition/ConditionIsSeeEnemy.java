package com.lizhao.ai.impl.condition;

import com.lizhao.ai.common.EStatus;
import com.lizhao.ai.abs.BaseCondition;
import com.lizhao.ai.ifs.IBehaviour;

public class ConditionIsSeeEnemy extends BaseCondition {

  @Override
  public EStatus update() {
    int random = getRandom();
    if (random < 50) {
      System.out.println("SeeEnemy");
      return !isNegation() ? EStatus.Success : EStatus.Failure;
    } else {
      System.out.println("Not SeeEnemy");
      return !isNegation() ? EStatus.Failure : EStatus.Success;
    }

  }

  @Override
  public void addChild(IBehaviour child) {
  }
}
