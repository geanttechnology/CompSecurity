.class public Lcn/jpush/android/service/PushReceiver;
.super Landroid/content/BroadcastReceiver;


# static fields
.field public static a:Lcn/jpush/android/data/d;

.field private static final z:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/16 v0, 0x2f

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "\u000fpZ85O?j?|O70"

    const/4 v0, -0x1

    move-object v4, v3

    :goto_0
    invoke-virtual {v1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    array-length v5, v1

    const/4 v6, 0x0

    const/4 v7, 0x1

    if-gt v5, v7, :cond_2

    :cond_0
    move-object v7, v1

    move v8, v6

    move v11, v5

    move-object v5, v1

    move v1, v11

    :goto_1
    aget-char v10, v5, v6

    rem-int/lit8 v9, v8, 0x5

    packed-switch v9, :pswitch_data_0

    const/16 v9, 0x15

    :goto_2
    xor-int/2addr v9, v10

    int-to-char v9, v9

    aput-char v9, v5, v6

    add-int/lit8 v6, v8, 0x1

    if-nez v1, :cond_1

    move-object v5, v7

    move v8, v6

    move v6, v1

    goto :goto_1

    :cond_1
    move v5, v1

    move-object v1, v7

    :cond_2
    if-gt v5, v6, :cond_0

    new-instance v5, Ljava/lang/String;

    invoke-direct {v5, v1}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v5}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    packed-switch v0, :pswitch_data_1

    aput-object v1, v3, v2

    const/4 v2, 0x1

    const-string v1, "\u6598\u6c85\u4e33\u6cf6\u671c\u8c22\u7578"

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "B>0=eT#vytO4l8|E~P\u0018Ah\u0016W\u0014Tu\u0019Q\u0019Ju\tN\u0012"

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "`\u0013J\u001eZo\u000fP\u0018Ah\u0016W\u0014Tu\u0019Q\u0019Js\u0015]\u0012\\w\u0015Z\u0008Es\u001fF\u000e5\u0001pp8aH6w4tU9q9JU)n25\u001cp"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, "+Z\u6732\u6387\u792f\u53cb\u5778\u5f1e\u5386\u6246\u5324\u72e6\u601f\u4e5c\u51ef\u7391|\u53cf\u5e54\u6246\u5324\u4e5d\u4f04\u51ad\u73a5\u000f"

    const/4 v0, 0x3

    move-object v3, v4

    goto :goto_0

    :pswitch_3
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "+\u001aN\"fI\u0019p#pS6\u007f4p\u000f?p\u0005pR%s2=\u0008"

    const/4 v0, 0x4

    move-object v3, v4

    goto :goto_0

    :pswitch_4
    aput-object v1, v3, v2

    const/4 v2, 0x6

    const-string v1, "R$l\u0019AX {w(\u0001"

    const/4 v0, 0x5

    move-object v3, v4

    goto :goto_0

    :pswitch_5
    aput-object v1, v3, v2

    const/4 v2, 0x7

    const-string v1, "Q1}<tF5$"

    const/4 v0, 0x6

    move-object v3, v4

    goto :goto_0

    :pswitch_6
    aput-object v1, v3, v2

    const/16 v2, 0x8

    const-string v1, "U)n2"

    const/4 v0, 0x7

    move-object v3, v4

    goto :goto_0

    :pswitch_7
    aput-object v1, v3, v2

    const/16 v2, 0x9

    const-string v1, "@>z%zH40>{U5p#;@3j>zO~N\u0016Vj\u0011Y\u0012J`\u0014Z\u0012Q"

    const/16 v0, 0x8

    move-object v3, v4

    goto :goto_0

    :pswitch_8
    aput-object v1, v3, v2

    const/16 v2, 0xa

    const-string v1, "@3j>cH$g"

    const/16 v0, 0x9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9
    aput-object v1, v3, v2

    const/16 v2, 0xb

    const-string v1, "@>z%zH40>{U5p#;@3j>zO~\\\u0018Zu\u000f]\u0018Xq\u001c[\u0003Pe"

    const/16 v0, 0xa

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a
    aput-object v1, v3, v2

    const/16 v2, 0xc

    const-string v1, "B>0=eT#vytO4l8|E~w9aD>jy[n\u0004W\u0011\\b\u0011J\u001eZo\u000fQ\u0007Po\u0015Z"

    const/16 v0, 0xb

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b
    aput-object v1, v3, v2

    const/16 v2, 0xd

    const-string v1, "C?z."

    const/16 v0, 0xc

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c
    aput-object v1, v3, v2

    const/16 v2, 0xe

    const-string v1, "B>0=eT#vytO4l8|E~w9aD>jy[n\u0004W\u0011\\b\u0011J\u001eZo\u000fW\u0019Fu\u0011R\u001bJb\u001cW\u0014^d\u0014"

    const/16 v0, 0xd

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d
    aput-object v1, v3, v2

    const/16 v2, 0xf

    const-string v1, "@ n;|B1j>zO\u007fh9q\u000f1p3gN9zye@3u6rD}\u007f%vI9h2"

    const/16 v0, 0xe

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_e
    aput-object v1, v3, v2

    const/16 v2, 0x10

    const-string v1, "O5j zS;W9sN"

    const/16 v0, 0xf

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_f
    aput-object v1, v3, v2

    const/16 v2, 0x11

    const-string v1, "B>0=eT#vytO4l8|E~w9aD>jy[n\u0004W\u0011\\b\u0011J\u001eZo\u000fQ\u0007Po\u0015Z\u0008Es\u001fF\u000e"

    const/16 v0, 0x10

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_10
    aput-object v1, v3, v2

    const/16 v2, 0x12

    const-string v1, "E5|\"r~>q#|G9}6aH?p"

    const/16 v0, 0x11

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_11
    aput-object v1, v3, v2

    const/16 v2, 0x13

    const-string v1, "O?]8{O5}#|W9j."

    const/16 v0, 0x12

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_12
    aput-object v1, v3, v2

    const/16 v2, 0x14

    const-string v1, "+\u76d4\u00148{q1k$p\ty\u0014"

    const/16 v0, 0x13

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_13
    aput-object v1, v3, v2

    const/16 v2, 0x15

    const-string v1, "@>z%zH40>{U5p#;@3j>zO~K\u0004Ps\u000fN\u0005Pr\u0015P\u0003"

    const/16 v0, 0x14

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_14
    aput-object v1, v3, v2

    const/16 v2, 0x16

    const-string v1, "@ n"

    const/16 v0, 0x15

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_15
    aput-object v1, v3, v2

    const/16 v2, 0x17

    const-string v1, "k\u0000k$}\u0001\u5eaa\u8bb0\u9691\u6205\u0001\u0003Z\u001c5\u65d7\u52f0\u4e14\u7e88\u8bb4\u4ec2\u7851\u4efb\u8b93\u4f25\u6389\u9051\u6556\u67cb\u3017\u0001Z\u0014\u6897\u6d5e\u5211\u5778\u0014"

    const/16 v0, 0x16

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_16
    aput-object v1, v3, v2

    const/16 v2, 0x18

    const-string v1, "N$v2g\u0001>{#bN\"uwfU1j25\u000cp"

    const/16 v0, 0x17

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_17
    aput-object v1, v3, v2

    const/16 v2, 0x19

    const-string v1, "O?j>sH3\u007f>zO\u000fj.eD"

    const/16 v0, 0x18

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_18
    aput-object v1, v3, v2

    const/16 v2, 0x1a

    const-string v1, "N>L2vD9h25\u000cp"

    const/16 v0, 0x19

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_19
    aput-object v1, v3, v2

    const/16 v2, 0x1b

    const-string v1, "b?p9pB$w8{\u0001#j6aDp}?tO7{35U?>z5"

    const/16 v0, 0x1a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1a
    aput-object v1, v3, v2

    const/16 v2, 0x1c

    const-string v1, "+\u76d4\u00148{s5m\"xDx7]zO\u0000\u007f\"fDx7]"

    const/16 v0, 0x1b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1b
    aput-object v1, v3, v2

    const/16 v2, 0x1d

    const-string v1, "B>0=eT#vytO4l8|E~w9aD>jy[n\u0004W\u0011\\b\u0011J\u001eZo\u000fL\u0012Vd\u0019H\u0012Q~\u0000L\u0018Mx"

    const/16 v0, 0x1c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1c
    aput-object v1, v3, v2

    const/16 v2, 0x1e

    const-string v1, "U?\u007f$au5f#"

    const/16 v0, 0x1d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1d
    aput-object v1, v3, v2

    const/16 v2, 0x1f

    const-string v1, "q%m?GD3{>cD\""

    const/16 v0, 0x1e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1e
    aput-object v1, v3, v2

    const/16 v2, 0x20

    const-string v1, "L5m$tF5"

    const/16 v0, 0x1f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1f
    aput-object v1, v3, v2

    const/16 v2, 0x21

    const-string v1, "@>z%zH40>{U5p#;@3j>zO~H\u001ePv"

    const/16 v0, 0x20

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_20
    aput-object v1, v3, v2

    const/16 v2, 0x22

    const-string v1, "O?j\u0008tT$q%`O"

    const/16 v0, 0x21

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_21
    aput-object v1, v3, v2

    const/16 v2, 0x23

    const-string v1, "L#y\u0008|E"

    const/16 v0, 0x22

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_22
    aput-object v1, v3, v2

    const/16 v2, 0x24

    const-string v1, "R5p3pS\u0019z"

    const/16 v0, 0x23

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_23
    aput-object v1, v3, v2

    const/16 v2, 0x25

    const-string v1, "+\u76d4\u00148{s5m\"xDx7]"

    const/16 v0, 0x24

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_24
    aput-object v1, v3, v2

    const/16 v2, 0x26

    const-string v1, "@ n\u001eq"

    const/16 v0, 0x25

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_25
    aput-object v1, v3, v2

    const/16 v2, 0x27

    const-string v1, "@>z%zH409pU~}8{O~]\u0018[o\u0015]\u0003\\w\u0019J\u000eJb\u0018_\u0019Rd"

    const/16 v0, 0x26

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_26
    aput-object v1, v3, v2

    const/16 v2, 0x28

    const-string v1, "o?>\u0016Vu\u0019Q\u0019Jo\u001fJ\u001eSh\u0013_\u0003\\n\u001eA\u0018Ed\u001e[\u00135E5x>{D4>>{\u0001=\u007f9|G5m#9\u0001?n2{\u0001$v25E5x6`M$>:tH>>6vU9h>aX"

    const/16 v0, 0x27

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_27
    aput-object v1, v3, v2

    const/16 v2, 0x29

    const-string v1, "@>z%zH40>{U5p#;@3j>zO~N\u0016Vj\u0011Y\u0012Js\u0015S\u0018Cd\u0014"

    const/16 v0, 0x28

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_28
    aput-object v1, v3, v2

    const/16 v2, 0x2a

    const-string v1, "B>0=eT#vytO4l8|E~N\u0002Fi\u000fW\u0013"

    const/16 v0, 0x29

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_29
    aput-object v1, v3, v2

    const/16 v2, 0x2b

    const-string v1, "+\u001aN\"fI\u0019p#pS6\u007f4p\u000f?p\u0005pR%s2=\u0008ZT\u0007`R8W9aD\"x6vD~q9E@%m2=\u0008"

    const/16 v0, 0x2a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2a
    aput-object v1, v3, v2

    const/16 v2, 0x2c

    const-string v1, "r5p35C\"q6qB1m#5U?>6eQj>"

    const/16 v0, 0x2b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2b
    aput-object v1, v3, v2

    const/16 v2, 0x2d

    const-string v1, "\u000f {%xH#m>zO~T\u0007@r\u0018A\u001aPr\u0003_\u0010P"

    const/16 v0, 0x2c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2c
    aput-object v1, v3, v2

    const/16 v2, 0x2e

    const-string v1, "+\u001aN\"fI\u0019p#pS6\u007f4p\u000f?p\u0007tT#{\u007f<"

    const/16 v0, 0x2d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2d
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/4 v0, 0x0

    sput-object v0, Lcn/jpush/android/service/PushReceiver;->a:Lcn/jpush/android/data/d;

    return-void

    :pswitch_2e
    const/16 v9, 0x21

    goto/16 :goto_2

    :pswitch_2f
    const/16 v9, 0x50

    goto/16 :goto_2

    :pswitch_30
    const/16 v9, 0x1e

    goto/16 :goto_2

    :pswitch_31
    const/16 v9, 0x57

    goto/16 :goto_2

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2e
        :pswitch_2f
        :pswitch_30
        :pswitch_31
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
        :pswitch_16
        :pswitch_17
        :pswitch_18
        :pswitch_19
        :pswitch_1a
        :pswitch_1b
        :pswitch_1c
        :pswitch_1d
        :pswitch_1e
        :pswitch_1f
        :pswitch_20
        :pswitch_21
        :pswitch_22
        :pswitch_23
        :pswitch_24
        :pswitch_25
        :pswitch_26
        :pswitch_27
        :pswitch_28
        :pswitch_29
        :pswitch_2a
        :pswitch_2b
        :pswitch_2c
        :pswitch_2d
    .end packed-switch
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 13

    const/4 v6, 0x2

    const v12, -0xce6801

    const/16 v11, 0x21

    const/4 v4, 0x0

    const/4 v3, 0x1

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v5, 0x1a

    aget-object v2, v2, v5

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/a;->a(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    if-eqz v0, :cond_0

    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0xb

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-static {p1}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;)V

    invoke-static {p1}, Lcn/jpush/android/util/k;->d(Landroid/content/Context;)V

    invoke-static {}, Lcn/jpush/android/service/PushService;->a()Z

    move-result v0

    if-eqz v0, :cond_2

    const/16 v0, 0x1f4

    invoke-static {p1, v0}, Lcn/jpush/android/service/ServiceInterface;->c(Landroid/content/Context;I)V

    goto :goto_0

    :cond_2
    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    goto :goto_0

    :cond_3
    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0x9

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-virtual {p2}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/4 v2, 0x7

    aget-object v1, v1, v2

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v3

    invoke-static {p1, v3}, Lcn/jpush/android/data/c;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v3}, Lcn/jpush/android/service/p;->a(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-static {p1, v1}, Lcn/jpush/android/service/ServiceInterface;->a(Landroid/content/Context;Lorg/json/JSONObject;)V

    :try_start_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    array-length v0, v4

    if-lez v0, :cond_0

    const/4 v0, 0x0

    aget-object v1, v4, v0

    const/16 v0, 0x3ea

    invoke-static {v1, v0, p1}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    const-string v0, ""

    array-length v2, v4

    if-lt v2, v6, :cond_20

    const/4 v0, 0x1

    aget-object v0, v4, v0

    move-object v2, v0

    :goto_1
    const-string v0, ""

    array-length v5, v4

    const/4 v6, 0x3

    if-lt v5, v6, :cond_4

    const/4 v0, 0x2

    aget-object v0, v4, v0

    :cond_4
    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    sget-object v4, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v5, 0x22

    aget-object v4, v4, v5

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_5

    invoke-static {p1, v3, v2}, Lcn/jpush/android/util/a;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/16 v2, 0x44c

    invoke-static {v1, v2, p1}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    :cond_5
    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1f

    :goto_2
    invoke-static {p1, v0}, Lcn/jpush/android/api/m;->a(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_0

    :cond_6
    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0x29

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    invoke-virtual {p2}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/4 v2, 0x7

    aget-object v1, v1, v2

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/service/p;->b(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {p1, v0}, Lcn/jpush/android/service/ServiceInterface;->a(Landroid/content/Context;Lorg/json/JSONObject;)V

    goto/16 :goto_0

    :cond_7
    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0x15

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    sget-boolean v0, Lcn/jpush/android/service/PushService;->q:Z

    if-eqz v0, :cond_0

    invoke-static {}, Lcn/jpush/android/service/PushService;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p1}, Lcn/jpush/android/service/ServiceInterface;->c(Landroid/content/Context;)V

    goto/16 :goto_0

    :cond_8
    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0xe

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0xd

    aget-object v0, v0, v1

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcn/jpush/android/data/d;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcn/jpush/android/data/d;->a()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, v0, Lcn/jpush/android/data/d;->c:Ljava/lang/String;

    const/16 v2, 0x3f7

    invoke-static {v1, v2, p1}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    check-cast v0, Lcn/jpush/android/data/l;

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    sget-object v2, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    aget-object v2, v2, v11

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    new-instance v2, Ljava/io/File;

    iget-object v0, v0, Lcn/jpush/android/data/l;->ah:Ljava/lang/String;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v0

    sget-object v2, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v3, 0xf

    aget-object v2, v2, v3

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p1, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    :cond_9
    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0x1d

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_e

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x19

    aget-object v0, v0, v1

    invoke-virtual {p2, v0, v4}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/4 v4, 0x3

    aget-object v2, v2, v4

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-nez v0, :cond_b

    invoke-static {p1}, Lcn/jpush/android/service/ServiceInterface;->j(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    goto/16 :goto_0

    :cond_a
    invoke-static {p1}, Lcn/jpush/android/util/a;->o(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_b

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    goto/16 :goto_0

    :cond_b
    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x20

    aget-object v0, v0, v1

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0x24

    aget-object v1, v1, v2

    invoke-virtual {p2, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v4, 0x26

    aget-object v2, v2, v4

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-object v4, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v5, 0x23

    aget-object v4, v4, v5

    invoke-virtual {p2, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {p1, v0, v2, v1, v4}, Lcn/jpush/android/data/p;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcn/jpush/android/data/a;

    move-result-object v0

    if-nez v0, :cond_c

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    goto/16 :goto_0

    :cond_c
    iget-boolean v1, v0, Lcn/jpush/android/data/a;->e:Z

    if-eqz v1, :cond_d

    iput-boolean v3, v0, Lcn/jpush/android/data/a;->h:Z

    invoke-static {p1, v0}, Lcn/jpush/android/data/p;->a(Landroid/content/Context;Lcn/jpush/android/data/a;)V

    :cond_d
    invoke-virtual {p0}, Lcn/jpush/android/service/PushReceiver;->abortBroadcast()V

    goto/16 :goto_0

    :cond_e
    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0x11

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_18

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x12

    aget-object v0, v0, v1

    invoke-virtual {p2, v0, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_14

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0xa

    aget-object v0, v0, v1

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x8

    aget-object v0, v0, v1

    const/4 v1, -0x1

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v6

    const/4 v0, -0x1

    if-ne v6, v0, :cond_11

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x1e

    aget-object v0, v0, v1

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, v5, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->getView()Landroid/view/View;

    move-result-object v0

    instance-of v3, v0, Landroid/widget/LinearLayout;

    if-eqz v3, :cond_10

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    instance-of v3, v0, Landroid/widget/TextView;

    if-eqz v3, :cond_10

    check-cast v0, Landroid/widget/TextView;

    invoke-static {v1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_f
    const/high16 v1, 0x41500000    # 13.0f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextSize(F)V

    :cond_10
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    :cond_11
    invoke-static {v5}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x17

    aget-object v7, v0, v1

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x25

    aget-object v2, v0, v1

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    aget-object v0, v0, v3

    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/4 v8, 0x5

    aget-object v1, v1, v8

    packed-switch v6, :pswitch_data_0

    :goto_3
    :pswitch_0
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/4 v10, 0x4

    aget-object v9, v9, v10

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v8, Landroid/text/SpannableStringBuilder;

    invoke-direct {v8, v6}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v7

    add-int/2addr v7, v6

    new-instance v9, Landroid/text/style/ForegroundColorSpan;

    invoke-direct {v9, v12}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v8, v9, v6, v7, v11}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    add-int/lit8 v6, v7, 0x2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v2, v6

    add-int/lit8 v2, v2, -0x2

    new-instance v7, Landroid/text/style/ForegroundColorSpan;

    invoke-direct {v7, v12}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v8, v7, v6, v2, v11}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    add-int/2addr v0, v2

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v1, v0

    new-instance v2, Landroid/text/style/ForegroundColorSpan;

    invoke-direct {v2, v12}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v8, v2, v0, v1, v11}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    invoke-static {p1, v5, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->getView()Landroid/view/View;

    move-result-object v0

    instance-of v2, v0, Landroid/widget/LinearLayout;

    if-eqz v2, :cond_13

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    instance-of v2, v0, Landroid/widget/TextView;

    if-eqz v2, :cond_13

    check-cast v0, Landroid/widget/TextView;

    if-eqz v8, :cond_12

    invoke-virtual {v0, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_12
    const/high16 v2, 0x41500000    # 13.0f

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setTextSize(F)V

    :cond_13
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    :pswitch_1
    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x14

    aget-object v2, v0, v1

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    aget-object v0, v0, v3

    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v6, 0x2e

    aget-object v1, v1, v6

    goto/16 :goto_3

    :pswitch_2
    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x1c

    aget-object v2, v0, v1

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    aget-object v0, v0, v3

    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v6, 0x2b

    aget-object v1, v1, v6

    goto/16 :goto_3

    :cond_14
    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x2a

    aget-object v0, v0, v1

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_15

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    aget-object v0, v0, v6

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/4 v6, 0x6

    aget-object v5, v5, v6

    invoke-direct {v2, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-eqz v0, :cond_1e

    const-string v2, "1"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1e

    move v0, v3

    :goto_4
    if-eq v3, v0, :cond_15

    const/16 v0, 0x3e8

    invoke-static {v1, v0, p1}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    :cond_15
    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0xc

    aget-object v0, v0, v1

    invoke-static {p1, v0, v3}, Lcn/jpush/android/util/a;->a(Landroid/content/Context;Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_16

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x1f

    aget-object v0, v0, v1

    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0x28

    aget-object v1, v1, v2

    invoke-static {v0, v1}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p1}, Lcn/jpush/android/util/a;->f(Landroid/content/Context;)V

    goto/16 :goto_0

    :cond_16
    new-instance v1, Landroid/content/Intent;

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0xc

    aget-object v0, v0, v2

    invoke-direct {v1, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0x16

    aget-object v0, v0, v2

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_17

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    :cond_17
    invoke-virtual {v1, v0}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v4, 0x2c

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v3, 0x2d

    aget-object v2, v2, v3

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_18
    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0x27

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v1, 0x10

    aget-object v0, v0, v1

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/NetworkInfo;

    if-eqz v0, :cond_0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v5, 0x1b

    aget-object v2, v2, v5

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v2, 0x13

    aget-object v1, v1, v2

    invoke-virtual {p2, v1, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_19

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    sput-boolean v4, Lcn/jpush/android/service/a;->b:Z

    invoke-static {p1}, Lcn/jpush/android/service/ServiceInterface;->b(Landroid/content/Context;)V

    goto/16 :goto_0

    :cond_19
    sget-object v1, Landroid/net/NetworkInfo$State;->CONNECTED:Landroid/net/NetworkInfo$State;

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getState()Landroid/net/NetworkInfo$State;

    move-result-object v2

    if-ne v1, v2, :cond_1c

    invoke-static {p1}, Lcn/jpush/android/service/ServiceInterface;->f(Landroid/content/Context;)V

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    sput-boolean v3, Lcn/jpush/android/service/a;->b:Z

    invoke-static {}, Lcn/jpush/android/service/DownloadService;->a()Z

    move-result v0

    if-eqz v0, :cond_1a

    invoke-static {p1}, Lcn/jpush/android/service/DownloadService;->a(Landroid/content/Context;)V

    :cond_1a
    sget-boolean v0, Lcn/jpush/android/service/PushService;->r:Z

    if-eqz v0, :cond_1b

    const/16 v0, 0xbb8

    invoke-static {p1, v0}, Lcn/jpush/android/service/ServiceInterface;->c(Landroid/content/Context;I)V

    :cond_1b
    sget-object v0, Lcn/jpush/android/service/PushReceiver;->a:Lcn/jpush/android/data/d;

    if-eqz v0, :cond_0

    sget-object v0, Lcn/jpush/android/service/PushReceiver;->a:Lcn/jpush/android/data/d;

    invoke-static {p1, v0}, Lcn/jpush/android/api/m;->b(Landroid/content/Context;Lcn/jpush/android/data/d;)V

    goto/16 :goto_0

    :cond_1c
    sget-object v1, Landroid/net/NetworkInfo$State;->DISCONNECTED:Landroid/net/NetworkInfo$State;

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getState()Landroid/net/NetworkInfo$State;

    move-result-object v2

    if-ne v1, v2, :cond_1d

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    sput-boolean v4, Lcn/jpush/android/service/a;->b:Z

    invoke-static {p1}, Lcn/jpush/android/service/ServiceInterface;->b(Landroid/content/Context;)V

    goto/16 :goto_0

    :cond_1d
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    const/16 v3, 0x18

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getState()Landroid/net/NetworkInfo$State;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushReceiver;->z:[Ljava/lang/String;

    aget-object v1, v1, v4

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_0

    :cond_1e
    move v0, v4

    goto/16 :goto_4

    :cond_1f
    move-object v0, v1

    goto/16 :goto_2

    :cond_20
    move-object v2, v0

    goto/16 :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
