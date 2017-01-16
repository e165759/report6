package jp.ac.uryukyu.ie.e165759;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
class Enemy extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    Enemy(String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }

    @Override
    void attack(LivingThing opponent){
        if(this.dead){
            return;
        }
        int damage = (int)(Math.random() * attack);
        double critical = Math.random();


        if (damage == 0){
            System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", name, opponent.getName());
            opponent.wounded(damage);
        }else if( 0 <=critical && critical < 0.2 ){
            damage = damage * 2;
            System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }else{
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }
}
