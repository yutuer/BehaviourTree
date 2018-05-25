package com.lizhao;

import com.lizhao.ai.BehaviorTree;
import com.lizhao.ai.BehaviorTreeBuilder;
import com.lizhao.ai.impl.action.ActionAttack;
import com.lizhao.ai.impl.action.ActionPatrol;
import com.lizhao.ai.impl.action.ActionRunaway;
import com.lizhao.ai.impl.composite.SelectorImpl;
import com.lizhao.ai.impl.composite.SequenceImpl;
import com.lizhao.ai.impl.condition.ConditionIsHealthLow;
import com.lizhao.ai.impl.condition.ConditionIsSeeEnemy;

public class Main {
  public static void main(String[] args) {
    BehaviorTreeBuilder builder = new BehaviorTreeBuilder();
    BehaviorTree behaviorTree =
          builder.addBehaviour(new SelectorImpl())
            .addBehaviour(new SequenceImpl())
              .addBehaviour(new ConditionIsSeeEnemy())
                .back()
              .addBehaviour(new SelectorImpl())
                .addBehaviour(new SequenceImpl())
                  .addBehaviour(new ConditionIsHealthLow())
                    .back()
                  .addBehaviour(new ActionRunaway())
                    .back()
                  .back()
                .addBehaviour(new ActionAttack())
                  .back()
                .back()
              .back()
            .addBehaviour(new ActionPatrol())
        .end();

    //模拟执行行为树
    for (int i = 0; i < 10; ++i){
      behaviorTree.tick();
      System.out.println("--------------" + i + "------------");
    }

    System.out.println("pause ");
  }
}
