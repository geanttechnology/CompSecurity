.class public final Lcn/jpush/android/data/p;
.super Ljava/lang/Object;


# static fields
.field private static final z:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/16 v0, 0x1d

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "{\u0016<A"

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

    const/16 v9, 0x35

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

    const-string v1, "e1\u000ciYE;Z}G@\u007fW("

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "r\u0004\u0012|A\\#\u0012|A\\,\'#\u000f\u0003pT\""

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "b\n6D\u0015O0\u0014|PT+"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, "M<\u000eaZBe\u0016gTH\u0012\to\u007f_0\u0014NGC2/zY\u000crZ"

    const/4 v0, 0x3

    move-object v3, v4

    goto :goto_0

    :pswitch_3
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "j>\u0013dPH\u007f\u000eg\u0015K:\u000e(__0\u0014(S^0\u0017(@^3ZjPO>\u000f{PC9Za[Z>\u0016aQ\u000c*\u0008d\u0015\u0001\u007f"

    const/4 v0, 0x4

    move-object v3, v4

    goto :goto_0

    :pswitch_4
    aput-object v1, v3, v2

    const/4 v2, 0x6

    const-string v1, "M;%aQ"

    const/4 v0, 0x5

    move-object v3, v4

    goto :goto_0

    :pswitch_5
    aput-object v1, v3, v2

    const/4 v2, 0x7

    const-string v1, "_7\u0015\u007fjX&\nm"

    const/4 v0, 0x6

    move-object v3, v4

    goto :goto_0

    :pswitch_6
    aput-object v1, v3, v2

    const/16 v2, 0x8

    const-string v1, "b\u0010ZEfk\u0016>"

    const/4 v0, 0x7

    move-object v3, v4

    goto :goto_0

    :pswitch_7
    aput-object v1, v3, v2

    const/16 v2, 0x9

    const-string v1, "M<\u000eaZBe\niG_:5z\\K6\u0014iYa,\u001dEP_,\u001boP\u000crZgGE8\u0013fT@\u0015\tg[\u0016U"

    const/16 v0, 0x8

    move-object v3, v4

    goto :goto_0

    :pswitch_8
    aput-object v1, v3, v2

    const/16 v2, 0xa

    const-string v1, "A\u0000\u0019g[X:\u0014|"

    const/16 v0, 0x9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9
    aput-object v1, v3, v2

    const/16 v2, 0xb

    const-string v1, "A,\u001dW\\H"

    const/16 v0, 0xa

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a
    aput-object v1, v3, v2

    const/16 v2, 0xc

    const-string v1, "M;%|"

    const/16 v0, 0xb

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b
    aput-object v1, v3, v2

    const/16 v2, 0xd

    const-string v1, "y1\u0011fZ[\u007f\u0017{R\u000c+\u0003xP\u000crZ"

    const/16 v0, 0xc

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c
    aput-object v1, v3, v2

    const/16 v2, 0xe

    const-string v1, "M<\u000eaZBe\nzP|>\u0008{Pc-\u0013o\\B>\u0016EFK\u0012\u001f{FM8\u001f(\u0018\u000c0\u0008aRE1\u001bd\u007f_0\u00142?"

    const/16 v0, 0xd

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d
    aput-object v1, v3, v2

    const/16 v2, 0xf

    const-string v1, "X6\u000edP"

    const/16 v0, 0xe

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_e
    aput-object v1, v3, v2

    const/16 v2, 0x10

    const-string v1, "Y-\u0016"

    const/16 v0, 0xf

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_f
    aput-object v1, v3, v2

    const/16 v2, 0x11

    const-string v1, "A:\t{TK:"

    const/16 v0, 0x10

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_10
    aput-object v1, v3, v2

    const/16 v2, 0x12

    const-string v1, "\\-\u001fXT^,\u001fGGE8\u0013fT@\u0012\toxI,\tiRI\u007f\u0017{Re;Z5\u0015"

    const/16 v0, 0x11

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_11
    aput-object v1, v3, v2

    const/16 v2, 0x13

    const-string v1, "^6\u0019`jA:\u001eaT"

    const/16 v0, 0x12

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_12
    aput-object v1, v3, v2

    const/16 v2, 0x14

    const-string v1, "O0\u0014|PB+%|L\\:"

    const/16 v0, 0x13

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_13
    aput-object v1, v3, v2

    const/16 v2, 0x15

    const-string v1, "B\u0000\u0018}\\@;\u001fzjE;"

    const/16 v0, 0x14

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_14
    aput-object v1, v3, v2

    const/16 v2, 0x16

    const-string v1, "b\u0010%Efk\u0016>"

    const/16 v0, 0x15

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_15
    aput-object v1, v3, v2

    const/16 v2, 0x17

    const-string v1, "B0\u000eaSE<\u001baZB\u0000\u000eqEI"

    const/16 v0, 0x16

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_16
    aput-object v1, v3, v2

    const/16 v2, 0x18

    const-string v1, "C)\u001fzGE;\u001fWX_8%aQ"

    const/16 v0, 0x17

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_17
    aput-object v1, v3, v2

    const/16 v2, 0x19

    const-string v1, "X&\nm"

    const/16 v0, 0x18

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_18
    aput-object v1, v3, v2

    const/16 v2, 0x1a

    const-string v1, "I\'\u000ezT_"

    const/16 v0, 0x19

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_19
    aput-object v1, v3, v2

    const/16 v2, 0x1b

    const-string v1, "B\u0000\u0015fYU"

    const/16 v0, 0x1a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1a
    aput-object v1, v3, v2

    const/16 v2, 0x1c

    const-string v1, "y1\u0011fZ[1ZEfk\u007f\nzZX0\u0019gY\u000c)\u001fzFE0\u0014&\u0015k6\u000cm\u0015Y/Z%\u0015"

    const/16 v0, 0x1b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1b
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    return-void

    :pswitch_1c
    const/16 v9, 0x2c

    goto/16 :goto_2

    :pswitch_1d
    const/16 v9, 0x5f

    goto/16 :goto_2

    :pswitch_1e
    const/16 v9, 0x7a

    goto/16 :goto_2

    :pswitch_1f
    const/16 v9, 0x8

    goto/16 :goto_2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1c
        :pswitch_1d
        :pswitch_1e
        :pswitch_1f
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
    .end packed-switch
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcn/jpush/android/data/a;
    .locals 9

    const/4 v0, 0x0

    const/4 v8, 0x3

    const/4 v4, 0x1

    const/4 v1, 0x0

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v5, 0xe

    aget-object v3, v3, v5

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-nez p0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    aget-object v1, v1, v8

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v2, 0x8

    aget-object v1, v1, v2

    const/16 v2, 0x3e4

    invoke-static {v1, v2, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    :goto_0
    return-object v0

    :cond_1
    sget-object v2, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v3, 0x16

    aget-object v2, v2, v3

    invoke-static {p0, v2, p1}, Lcn/jpush/android/data/p;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    if-nez v5, :cond_2

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto :goto_0

    :cond_2
    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v2, 0xb

    aget-object v0, v0, v2

    const-string v2, ""

    invoke-virtual {v5, v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    :goto_1
    invoke-static {p4}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v2, 0x6

    aget-object v0, v0, v2

    const-string v2, ""

    invoke-virtual {v5, v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p4

    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v3, 0x12

    aget-object v2, v2, v3

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v2, 0x1b

    aget-object v0, v0, v2

    invoke-virtual {v5, v0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    if-ne v0, v4, :cond_5

    move v3, v4

    :goto_2
    if-eqz v3, :cond_6

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v2, 0x15

    aget-object v0, v0, v2

    invoke-virtual {v5, v0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    :goto_3
    new-instance v2, Lcn/jpush/android/data/a;

    invoke-direct {v2}, Lcn/jpush/android/data/a;-><init>()V

    iput-object p4, v2, Lcn/jpush/android/data/a;->c:Ljava/lang/String;

    iput-object v5, v2, Lcn/jpush/android/data/a;->a:Lorg/json/JSONObject;

    sget-object v6, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v7, 0x7

    aget-object v6, v6, v7

    invoke-virtual {v5, v6, v8}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v6

    iput v6, v2, Lcn/jpush/android/data/a;->b:I

    iput-boolean v3, v2, Lcn/jpush/android/data/a;->e:Z

    iput v0, v2, Lcn/jpush/android/data/a;->f:I

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v3, 0x17

    aget-object v0, v0, v3

    invoke-virtual {v5, v0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, v2, Lcn/jpush/android/data/a;->g:I

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v1, 0x11

    aget-object v0, v0, v1

    const-string v1, ""

    invoke-virtual {v5, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcn/jpush/android/data/a;->i:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v1, 0x14

    aget-object v0, v0, v1

    const-string v1, ""

    invoke-virtual {v5, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcn/jpush/android/data/a;->j:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v1, 0xf

    aget-object v0, v0, v1

    const-string v1, ""

    invoke-virtual {v5, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcn/jpush/android/data/a;->k:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v1, 0x1a

    aget-object v0, v0, v1

    const-string v1, ""

    invoke-virtual {v5, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcn/jpush/android/data/a;->l:Ljava/lang/String;

    iput-object p2, v2, Lcn/jpush/android/data/a;->m:Ljava/lang/String;

    iput-object p3, v2, Lcn/jpush/android/data/a;->n:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v1, 0x18

    aget-object v0, v0, v1

    const-string v1, ""

    invoke-virtual {v5, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcn/jpush/android/data/a;->d:Ljava/lang/String;

    iget-object v0, v2, Lcn/jpush/android/data/a;->i:Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v1, 0x13

    aget-object v0, v0, v1

    invoke-static {p0, p4, v5, v0}, Lcn/jpush/android/data/p;->a(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_4

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v3, 0x10

    aget-object v1, v1, v3

    const-string v3, ""

    invoke-virtual {v0, v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcn/jpush/android/data/a;->a(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v3, 0x19

    aget-object v1, v1, v3

    const-string v3, ""

    invoke-virtual {v0, v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcn/jpush/android/data/a;->T:Ljava/lang/String;

    invoke-virtual {v2, v4}, Lcn/jpush/android/data/a;->a(Z)V

    :cond_4
    move-object v0, v2

    goto/16 :goto_0

    :cond_5
    move v3, v1

    goto/16 :goto_2

    :cond_6
    move v0, v1

    goto/16 :goto_3

    :cond_7
    move-object p4, v0

    goto/16 :goto_1
.end method

.method private static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 1

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    const/16 v0, 0x3e4

    invoke-static {p1, v0, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 3

    const/16 v2, 0x3e4

    const/4 v0, 0x0

    if-nez p2, :cond_1

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    invoke-static {p1, v2, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    goto :goto_0

    :cond_2
    :try_start_0
    invoke-virtual {p2, p3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p2, p3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v1

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    invoke-static {p1, v2, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Lcn/jpush/android/data/a;)V
    .locals 7

    const/16 v6, 0xa

    const/4 v4, 0x3

    const/16 v5, 0x3e4

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    if-nez p0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    aget-object v1, v1, v4

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget v1, p1, Lcn/jpush/android/data/a;->b:I

    iget-object v0, p1, Lcn/jpush/android/data/a;->a:Lorg/json/JSONObject;

    iget-object v2, p1, Lcn/jpush/android/data/a;->c:Ljava/lang/String;

    const/4 v3, 0x2

    if-ne v1, v3, :cond_2

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    aget-object v1, v1, v6

    const-string v3, ""

    invoke-virtual {v0, v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/data/p;->a(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {p0, v0, v2}, Lcn/jpush/android/data/p;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v4, 0x5

    aget-object v3, v3, v4

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-static {v2, v5, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto :goto_0

    :cond_2
    const/4 v3, 0x1

    if-eq v1, v3, :cond_3

    if-eq v1, v4, :cond_3

    const/4 v3, 0x4

    if-ne v1, v3, :cond_4

    :cond_3
    sget-object v3, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    aget-object v3, v3, v6

    invoke-static {p0, v2, v0, v3}, Lcn/jpush/android/data/p;->a(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    if-nez v3, :cond_5

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto :goto_0

    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v4, 0x1c

    aget-object v3, v3, v4

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-static {v2, v5, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto :goto_0

    :cond_5
    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v4, 0xc

    aget-object v0, v0, v4

    const/4 v4, -0x1

    invoke-virtual {v3, v0, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v4

    packed-switch v4, :pswitch_data_0

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v3, 0xd

    aget-object v1, v1, v3

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    invoke-static {v2, v5, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto :goto_0

    :pswitch_0
    new-instance v0, Lcn/jpush/android/data/s;

    invoke-direct {v0}, Lcn/jpush/android/data/s;-><init>()V

    :goto_1
    iput-object v2, v0, Lcn/jpush/android/data/d;->c:Ljava/lang/String;

    iput v1, v0, Lcn/jpush/android/data/d;->b:I

    iput v4, v0, Lcn/jpush/android/data/d;->o:I

    iget-boolean v1, p1, Lcn/jpush/android/data/a;->h:Z

    iput-boolean v1, v0, Lcn/jpush/android/data/d;->h:Z

    iget-boolean v1, p1, Lcn/jpush/android/data/a;->e:Z

    iput-boolean v1, v0, Lcn/jpush/android/data/d;->e:Z

    iget v1, p1, Lcn/jpush/android/data/a;->f:I

    iput v1, v0, Lcn/jpush/android/data/d;->f:I

    iget-object v1, p1, Lcn/jpush/android/data/a;->m:Ljava/lang/String;

    iput-object v1, v0, Lcn/jpush/android/data/d;->m:Ljava/lang/String;

    iget-object v1, p1, Lcn/jpush/android/data/a;->d:Ljava/lang/String;

    iput-object v1, v0, Lcn/jpush/android/data/d;->d:Ljava/lang/String;

    iget v1, p1, Lcn/jpush/android/data/a;->g:I

    iput v1, v0, Lcn/jpush/android/data/d;->g:I

    invoke-virtual {v0, p0, v3}, Lcn/jpush/android/data/d;->b(Landroid/content/Context;Lorg/json/JSONObject;)Z

    move-result v1

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    if-eqz v1, :cond_6

    invoke-virtual {v0, p0}, Lcn/jpush/android/data/d;->a(Landroid/content/Context;)V

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_0

    :pswitch_1
    new-instance v0, Lcn/jpush/android/data/l;

    invoke-direct {v0}, Lcn/jpush/android/data/l;-><init>()V

    goto :goto_1

    :pswitch_2
    new-instance v0, Lcn/jpush/android/data/y;

    invoke-direct {v0}, Lcn/jpush/android/data/y;-><init>()V

    goto :goto_1

    :pswitch_3
    new-instance v0, Lcn/jpush/android/data/x;

    invoke-direct {v0}, Lcn/jpush/android/data/x;-><init>()V

    goto :goto_1

    :cond_6
    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    goto/16 :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 8

    const/16 v7, 0x3e4

    const/16 v6, 0xa

    const/4 v5, -0x1

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v2, 0x9

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    if-nez p0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v2, 0x3

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    :cond_1
    :goto_0
    return-void

    :cond_2
    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v1, 0x8

    aget-object v0, v0, v1

    invoke-static {p0, v0, p1}, Lcn/jpush/android/data/p;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_1

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v1, 0xb

    aget-object v0, v0, v1

    const-string v1, ""

    invoke-virtual {v2, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v1, 0x6

    aget-object v0, v0, v1

    const-string v1, ""

    invoke-virtual {v2, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :cond_3
    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v3, 0x7

    aget-object v1, v1, v3

    invoke-virtual {v2, v1, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v3

    const/4 v1, 0x0

    const/4 v4, 0x2

    if-ne v3, v4, :cond_5

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    aget-object v1, v1, v6

    const-string v3, ""

    invoke-virtual {v2, v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/data/p;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-static {p0, v1, v0}, Lcn/jpush/android/data/p;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_4
    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v4, 0x5

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-static {v0, v7, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto :goto_0

    :cond_5
    const/4 v4, 0x1

    if-ne v3, v4, :cond_7

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    aget-object v1, v1, v6

    invoke-static {p0, v0, v2, v1}, Lcn/jpush/android/data/p;->a(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    move-object v2, v1

    :goto_1
    if-eqz v2, :cond_1

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v4, 0xc

    aget-object v1, v1, v4

    invoke-virtual {v2, v1, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v4

    packed-switch v4, :pswitch_data_0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/16 v3, 0xd

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    invoke-static {v0, v7, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto/16 :goto_0

    :pswitch_0
    new-instance v1, Lcn/jpush/android/data/s;

    invoke-direct {v1}, Lcn/jpush/android/data/s;-><init>()V

    :goto_2
    invoke-virtual {v1, p0, v2}, Lcn/jpush/android/data/d;->b(Landroid/content/Context;Lorg/json/JSONObject;)Z

    move-result v2

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    iput-object v0, v1, Lcn/jpush/android/data/d;->c:Ljava/lang/String;

    iput v3, v1, Lcn/jpush/android/data/d;->b:I

    iput v4, v1, Lcn/jpush/android/data/d;->o:I

    if-eqz v2, :cond_6

    invoke-virtual {v1, p0}, Lcn/jpush/android/data/d;->a(Landroid/content/Context;)V

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_0

    :pswitch_1
    new-instance v1, Lcn/jpush/android/data/l;

    invoke-direct {v1}, Lcn/jpush/android/data/l;-><init>()V

    goto :goto_2

    :pswitch_2
    new-instance v1, Lcn/jpush/android/data/y;

    invoke-direct {v1}, Lcn/jpush/android/data/y;-><init>()V

    goto :goto_2

    :pswitch_3
    new-instance v1, Lcn/jpush/android/data/x;

    invoke-direct {v1}, Lcn/jpush/android/data/x;-><init>()V

    goto :goto_2

    :cond_6
    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    goto/16 :goto_0

    :cond_7
    move-object v2, v1

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static a(Ljava/lang/String;)Z
    .locals 5

    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x0

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v0, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v2, 0x2

    aget-object v0, v0, v2

    invoke-virtual {v1, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v4, 0x1

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    goto :goto_0
.end method

.method public static a(ZILandroid/content/Context;)Z
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    sget-object v2, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    aget-object v2, v2, v1

    invoke-static {p2}, Lcn/jpush/android/util/a;->e(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz p0, :cond_0

    if-eqz p1, :cond_1

    :cond_0
    if-eqz p0, :cond_2

    if-ne p1, v0, :cond_2

    if-eqz v2, :cond_2

    :cond_1
    :goto_0
    return v0

    :cond_2
    move v0, v1

    goto :goto_0
.end method

.method private static b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v2, 0x4

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    if-nez p0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    sget-object v1, Lcn/jpush/android/data/p;->z:[Ljava/lang/String;

    const/4 v2, 0x3

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    new-instance v0, Lcn/jpush/android/data/q;

    invoke-direct {v0, p1, p0, p2}, Lcn/jpush/android/data/q;-><init>(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcn/jpush/android/data/q;->start()V

    return-void
.end method
