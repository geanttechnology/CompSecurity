.class public final Lcn/jpush/android/service/n;
.super Ljava/lang/Thread;


# static fields
.field private static final z:[Ljava/lang/String;


# instance fields
.field a:Z

.field final synthetic b:Lcn/jpush/android/service/PushService;

.field private volatile c:Z


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/16 v0, 0x2d

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "i|.9\u000f\u000cq52\u0013Iq.5\u0012B2.4\u000fIs>\u0015\u0019\u000c/z"

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

    const/16 v9, 0x7d

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

    const-string v1, "~w9*@\tv"

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "|g)4.I`,5\u001eI"

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "e|3(@\tvP"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, "`}=5\u0013\u000ct;5\u0011Ivv|\tD`?=\u0019evza]"

    const/4 v0, 0x3

    move-object v3, v4

    goto :goto_0

    :pswitch_3
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "`}=5\u0013\u000ca/?\u001eIw>}]^w=5\u000eX`;(\u0014C|\u0013\u0018@"

    const/4 v0, 0x4

    move-object v3, v4

    goto :goto_0

    :pswitch_4
    aput-object v1, v3, v2

    const/4 v2, 0x6

    const-string v1, "e|3(][{.4]\u00012"

    const/4 v0, 0x5

    move-object v3, v4

    goto :goto_0

    :pswitch_5
    aput-object v1, v3, v2

    const/4 v2, 0x7

    const-string v1, "O`?=\tI2)3\u001eGw.|\u001bM~39\u0019\u000ce3(\u0015\u000cf2.\u0018Mv\u00138]\u00112"

    const/4 v0, 0x6

    move-object v3, v4

    goto :goto_0

    :pswitch_6
    aput-object v1, v3, v2

    const/16 v2, 0x8

    const-string v1, "O|t6\rYa2r\u001cBv(3\u0014H<32\tI|.r>c\\\u0014\u0019>x[\u0015\u0012"

    const/4 v0, 0x7

    move-object v3, v4

    goto :goto_0

    :pswitch_7
    aput-object v1, v3, v2

    const/16 v2, 0x9

    const-string v1, "\u000c\u007f\n3\u000fX2g|"

    const/16 v0, 0x8

    move-object v3, v4

    goto :goto_0

    :pswitch_8
    aput-object v1, v3, v2

    const/16 v2, 0xa

    const-string v1, "\u000c2z|]\u000c\u007f\u00123\u000eX(zqC\u000c"

    const/16 v0, 0x9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9
    aput-object v1, v3, v2

    const/16 v2, 0xb

    const-string v1, "`}=5\u0013\u000ct;5\u0011Iv`|"

    const/16 v0, 0xa

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a
    aput-object v1, v3, v2

    const/16 v2, 0xc

    const-string v1, "h\\\tf]\u0001,z"

    const/16 v0, 0xb

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b
    aput-object v1, v3, v2

    const/16 v2, 0xd

    const-string v1, "ij3(]^w99\u0014Z{4;][z30\u0018\u000c~53\r\u00002.4\u000fIs>\u0015\u0019\u000c/z"

    const/16 v0, 0xc

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c
    aput-object v1, v3, v2

    const/16 v2, 0xe

    const-string v1, "_}((\"Gw#|G\u000c"

    const/16 v0, 0xd

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d
    aput-object v1, v3, v2

    const/16 v2, 0xf

    const-string v1, "@}=5\u0013ng<:\u0018^2g|"

    const/16 v0, 0xe

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_e
    aput-object v1, v3, v2

    const/16 v2, 0x10

    const-string v1, "\u000c?z"

    const/16 v0, 0xf

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_f
    aput-object v1, v3, v2

    const/16 v2, 0x11

    const-string v1, "^w.|@\u000c"

    const/16 v0, 0x10

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_10
    aput-object v1, v3, v2

    const/16 v2, 0x12

    const-string v1, "aVo"

    const/16 v0, 0x11

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_11
    aput-object v1, v3, v2

    const/16 v2, 0x13

    const-string v1, "`}=5\u0013\u001627\u0015\u0019\u000c/zy\u0019\u00002\n=\u000e_e5.\u0019\u000c\u007f>i]\u00112\u007f/"

    const/16 v0, 0x12

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_12
    aput-object v1, v3, v2

    const/16 v2, 0x14

    const-string v1, "\u000c/z"

    const/16 v0, 0x13

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_13
    aput-object v1, v3, v2

    const/16 v2, 0x15

    const-string v1, "\\s(/\u0018`w4|@\u000c"

    const/16 v0, 0x14

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_14
    aput-object v1, v3, v2

    const/16 v2, 0x16

    const-string v1, "\u001d<mrL"

    const/16 v0, 0x15

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_15
    aput-object v1, v3, v2

    const/16 v2, 0x17

    const-string v1, "@}=5\u0013\u000ct;5\u0011\u000c(z/\u0012^f\u00057\u0018U2g|"

    const/16 v0, 0x16

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_16
    aput-object v1, v3, v2

    const/16 v2, 0x18

    const-string v1, "\u000c2z?\u0012A\u007f;2\u0019\u000c/z"

    const/16 v0, 0x17

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_17
    aput-object v1, v3, v2

    const/16 v2, 0x19

    const-string v1, "_{>|@\u000c"

    const/16 v0, 0x18

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_18
    aput-object v1, v3, v2

    const/16 v2, 0x1a

    const-string v1, "\u000c2z(\u0012Xs6\u0010\u0018B2g|"

    const/16 v0, 0x19

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_19
    aput-object v1, v3, v2

    const/16 v2, 0x1b

    const-string v1, "\u000c|5(]Ij3/\t_2`|\u0014Ba?.\t"

    const/16 v0, 0x1a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1a
    aput-object v1, v3, v2

    const/16 v2, 0x1c

    const-string v1, "@}=5\u0013\u000ct;5\u0011\u000c(z\u0010\u0012K{4a"

    const/16 v0, 0x1b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1b
    aput-object v1, v3, v2

    const/16 v2, 0x1d

    const-string v1, "\u000cq;2\u0013Cfz,\u001c^a?|\u000eI`,9\u000fx{79]"

    const/16 v0, 0x1c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1c
    aput-object v1, v3, v2

    const/16 v2, 0x1e

    const-string v1, "@}=5\u0013s`?,\u0012^f\u0005(\u0014Aw"

    const/16 v0, 0x1d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1d
    aput-object v1, v3, v2

    const/16 v2, 0x1f

    const-string v1, "\u000cf5(\u0012@^?2]\u00112"

    const/16 v0, 0x1e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1e
    aput-object v1, v3, v2

    const/16 v2, 0x20

    const-string v1, "@}=5\u0013\u000ct;5\u0011\u000c(z(\u0012X}6\u0010\u0018B2g|"

    const/16 v0, 0x1f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1f
    aput-object v1, v3, v2

    const/16 v2, 0x21

    const-string v1, "p<"

    const/16 v0, 0x20

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_20
    aput-object v1, v3, v2

    const/16 v2, 0x22

    const-string v1, "_f(\u0017\u0018U2g|"

    const/16 v0, 0x21

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_21
    aput-object v1, v3, v2

    const/16 v2, 0x23

    const-string v1, "_d?.\u000eE}4|@\u000c"

    const/16 v0, 0x22

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_22
    aput-object v1, v3, v2

    const/16 v2, 0x24

    const-string v1, "_}((\"Gw#f"

    const/16 v0, 0x23

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_23
    aput-object v1, v3, v2

    const/16 v2, 0x25

    const-string v1, "@}=5\u0013sa?.\u000bI`\u0005(\u0014Aw"

    const/16 v0, 0x24

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_24
    aput-object v1, v3, v2

    const/16 v2, 0x26

    const-string v1, "\u000c2z|]\u000c2z|]\u000c~5;\u0014BM93\u000eX{79G\u000c"

    const/16 v0, 0x25

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_25
    aput-object v1, v3, v2

    const/16 v2, 0x27

    const-string v1, "\u000c{)|\u0018T{)(\u000e\u000c(z)\rHs.9"

    const/16 v0, 0x26

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_26
    aput-object v1, v3, v2

    const/16 v2, 0x28

    const-string v1, "\u000c2z|\u000fIb5.\tx{79]\u00112"

    const/16 v0, 0x27

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_27
    aput-object v1, v3, v2

    const/16 v2, 0x29

    const-string v1, "\t\"h\u0004"

    const/16 v0, 0x28

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_28
    aput-object v1, v3, v2

    const/16 v2, 0x2a

    const-string v1, "_w(*\u0018^F31\u0018\u000c/z"

    const/16 v0, 0x29

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_29
    aput-object v1, v3, v2

    const/16 v2, 0x2b

    const-string v1, "_f31\u0018\u000c/z"

    const/16 v0, 0x2a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2a
    aput-object v1, v3, v2

    const/16 v2, 0x2c

    const-string v1, "`}=5\u0013\u00117>V"

    const/16 v0, 0x2b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2b
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    return-void

    :pswitch_2c
    const/16 v9, 0x2c

    goto/16 :goto_2

    :pswitch_2d
    const/16 v9, 0x12

    goto/16 :goto_2

    :pswitch_2e
    const/16 v9, 0x5a

    goto/16 :goto_2

    :pswitch_2f
    const/16 v9, 0x5c

    goto/16 :goto_2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2c
        :pswitch_2d
        :pswitch_2e
        :pswitch_2f
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
    .end packed-switch
.end method

.method public constructor <init>(Lcn/jpush/android/service/PushService;)V
    .locals 1

    iput-object p1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/jpush/android/service/n;->c:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/jpush/android/service/n;->a:Z

    return-void
.end method

.method private a()I
    .locals 17

    const/4 v9, 0x0

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v2, 0x12

    aget-object v1, v1, v2

    invoke-static {v1}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/PushService;->t:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    array-length v1, v2

    mul-int/lit8 v1, v1, 0x2

    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    array-length v4, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v4, :cond_0

    aget-byte v5, v2, v1

    sget-object v6, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v7, 0x29

    aget-object v6, v6, v7

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-static {v5}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v5

    aput-object v5, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v2, 0x13

    aget-object v1, v1, v2

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    sget-wide v6, Lcn/jpush/android/service/PushService;->s:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object v5, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v2, 0x16

    aget-object v1, v1, v2

    sget-object v2, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v3, 0x21

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    shl-int/lit8 v2, v2, 0x10

    const/4 v3, 0x1

    aget-object v3, v1, v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    shl-int/lit8 v3, v3, 0x8

    add-int/2addr v2, v3

    const/4 v3, 0x2

    aget-object v1, v1, v3

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    add-int v7, v2, v1

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/a;->f:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    sget-object v2, Lcn/jpush/android/a;->f:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v1, v0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v1, v1, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v1, :cond_15

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    move-object/from16 v0, p0

    iget-object v1, v0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v1}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/util/a;->w(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v15

    const/16 v1, 0x80

    new-array v2, v1, [B

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    move-object/from16 v0, p0

    iget-object v1, v0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v1, v1, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v3, Lcn/jpush/android/service/PushService;->s:J

    int-to-long v7, v7

    invoke-static/range {v1 .. v8}, Lcn/jpush/android/service/PushProtocol;->LogPushWithBack(I[BJLjava/lang/String;Ljava/lang/String;J)I

    move-result v13

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "_"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "_"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcn/jpush/android/service/PushService;->b()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "_"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcn/jpush/android/util/a;->d()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    sub-long v5, v3, v10

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v7, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v8, 0xe

    aget-object v7, v7, v8

    invoke-direct {v1, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v16

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v7, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v8, 0x26

    aget-object v7, v7, v8

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0x10

    aget-object v3, v3, v4

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0x14

    aget-object v3, v3, v4

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-eqz v13, :cond_1

    const/16 v1, 0x270f

    if-ne v13, v1, :cond_11

    :cond_1
    invoke-static {v2}, Lcn/jpush/android/util/a;->b([B)I

    move-result v1

    invoke-static {v2}, Lcn/jpush/android/util/a;->c([B)I

    move-result v7

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v8, 0x11

    aget-object v4, v4, v8

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v8, 0x18

    aget-object v4, v4, v8

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0x1f

    aget-object v3, v3, v4

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0xf

    aget-object v3, v3, v4

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2, v7}, Lcn/jpush/android/service/PushService;->a([BI)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    const/16 v1, 0x22

    if-ge v7, v1, :cond_2

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v3, 0x2

    aget-object v1, v1, v3

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v8, 0x20

    aget-object v4, v4, v8

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v8, 0x1d

    aget-object v4, v4, v8

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    const/4 v3, 0x0

    const/4 v1, 0x0

    :goto_1
    const/4 v4, 0x2

    if-ge v1, v4, :cond_3

    shl-int/lit8 v3, v3, 0x8

    add-int/lit8 v4, v1, 0x14

    aget-byte v4, v2, v4

    and-int/lit16 v4, v4, 0xff

    add-int/2addr v3, v4

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_3
    if-nez v3, :cond_9

    const-wide/16 v3, 0x0

    const/4 v1, 0x0

    :goto_2
    const/4 v8, 0x4

    if-ge v1, v8, :cond_4

    const/16 v8, 0x8

    shl-long/2addr v3, v8

    add-int/lit8 v8, v1, 0x16

    aget-byte v8, v2, v8

    and-int/lit16 v8, v8, 0xff

    int-to-long v10, v8

    add-long/2addr v3, v10

    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_4
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v8, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v10, 0x19

    aget-object v8, v8, v10

    invoke-direct {v1, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    const/4 v3, 0x0

    const/4 v1, 0x0

    :goto_3
    const/4 v4, 0x2

    if-ge v1, v4, :cond_5

    shl-int/lit8 v3, v3, 0x8

    add-int/lit8 v4, v1, 0x1a

    aget-byte v4, v2, v4

    and-int/lit16 v4, v4, 0xff

    add-int/2addr v3, v4

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_5
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v8, 0x23

    aget-object v4, v4, v8

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    const/4 v1, 0x0

    const/4 v3, 0x0

    move v4, v3

    move v3, v1

    :goto_4
    const/4 v1, 0x2

    if-ge v4, v1, :cond_6

    shl-int/lit8 v1, v3, 0x8

    add-int/lit8 v3, v4, 0x1c

    aget-byte v3, v2, v3

    and-int/lit16 v3, v3, 0xff

    add-int/2addr v1, v3

    add-int/lit8 v3, v4, 0x1

    move v4, v3

    move v3, v1

    goto :goto_4

    :cond_6
    new-array v4, v3, [B

    const/4 v1, 0x0

    :goto_5
    array-length v8, v4

    if-ge v1, v8, :cond_7

    add-int/lit8 v8, v1, 0x1e

    aget-byte v8, v2, v8

    and-int/lit16 v8, v8, 0xff

    int-to-byte v8, v8

    aput-byte v8, v4, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_7
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, v4}, Ljava/lang/String;-><init>([B)V

    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v8, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v10, 0x22

    aget-object v8, v8, v10

    invoke-direct {v4, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    add-int/lit8 v8, v3, 0x1e

    const-wide/16 v3, 0x0

    const/4 v1, 0x0

    :goto_6
    const/4 v10, 0x4

    if-ge v1, v10, :cond_8

    const/16 v10, 0x8

    shl-long/2addr v3, v10

    add-int v10, v8, v1

    aget-byte v10, v2, v10

    and-int/lit16 v10, v10, 0xff

    int-to-long v10, v10

    add-long/2addr v3, v10

    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    :cond_8
    add-int/lit8 v1, v8, 0x4

    if-ne v1, v7, :cond_10

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    :goto_7
    sput-wide v3, Lcn/jpush/android/service/PushService;->m:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v7, 0x3e8

    div-long/2addr v1, v7

    sput-wide v1, Lcn/jpush/android/service/PushService;->n:J

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v2, 0x2

    aget-object v1, v1, v2

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v7, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v8, 0x2b

    aget-object v7, v7, v8

    invoke-direct {v2, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/jpush/android/util/x;->c(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v3, 0x2a

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-wide v2, Lcn/jpush/android/service/PushService;->m:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v3, 0x28

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-wide v2, Lcn/jpush/android/service/PushService;->n:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    move-object/from16 v0, p0

    iget-object v1, v0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v1}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v3, 0x25

    aget-object v2, v2, v3

    sget-wide v3, Lcn/jpush/android/service/PushService;->m:J

    invoke-static {v1, v2, v3, v4}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;J)V

    move-object/from16 v0, p0

    iget-object v1, v0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v1}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v3, 0x1e

    aget-object v2, v2, v3

    sget-wide v3, Lcn/jpush/android/service/PushService;->n:J

    invoke-static {v1, v2, v3, v4}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;J)V

    :cond_9
    move v7, v9

    :goto_8
    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    if-nez v7, :cond_c

    const-wide/16 v1, 0x3e8

    cmp-long v1, v5, v1

    if-gtz v1, :cond_a

    const/4 v9, 0x1

    :cond_a
    const-wide/16 v1, 0x3e8

    cmp-long v1, v5, v1

    if-lez v1, :cond_b

    const-wide/16 v1, 0xbb8

    cmp-long v1, v5, v1

    if-gtz v1, :cond_b

    const/4 v10, 0x1

    :cond_b
    const-wide/16 v1, 0xbb8

    cmp-long v1, v5, v1

    if-lez v1, :cond_c

    const/4 v11, 0x1

    :cond_c
    new-instance v1, Lcn/jpush/android/data/u;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v2}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Lcn/jpush/android/data/u;-><init>(Landroid/content/Context;)V

    if-eqz v1, :cond_f

    invoke-virtual {v1}, Lcn/jpush/android/data/u;->a()V

    move-object/from16 v0, v16

    invoke-virtual {v1, v0}, Lcn/jpush/android/data/u;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_14

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0x24

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0x27

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    const/4 v2, 0x0

    :try_start_0
    move-object/from16 v0, v16

    invoke-virtual {v1, v0}, Lcn/jpush/android/data/u;->b(Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v14

    if-nez v14, :cond_d

    :try_start_1
    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    :cond_d
    invoke-static {v14}, Lcn/jpush/android/data/u;->a(Landroid/database/Cursor;)Lcn/jpush/android/data/w;

    move-result-object v2

    if-eqz v2, :cond_12

    invoke-static {}, Lcn/jpush/android/service/PushService;->b()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcn/jpush/android/util/a;->d()Ljava/lang/String;

    move-result-object v5

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2}, Lcn/jpush/android/data/w;->f()I

    move-result v3

    add-int/2addr v7, v3

    invoke-virtual {v2}, Lcn/jpush/android/data/w;->g()I

    move-result v3

    add-int/lit8 v8, v3, 0x1

    invoke-virtual {v2}, Lcn/jpush/android/data/w;->h()I

    move-result v3

    add-int/2addr v9, v3

    invoke-virtual {v2}, Lcn/jpush/android/data/w;->i()I

    move-result v3

    add-int/2addr v10, v3

    invoke-virtual {v2}, Lcn/jpush/android/data/w;->j()I

    move-result v3

    add-int/2addr v11, v3

    invoke-virtual {v2}, Lcn/jpush/android/data/w;->k()I

    move-result v2

    add-int/lit8 v12, v2, 0x0

    move-object/from16 v2, v16

    move-object v3, v15

    invoke-virtual/range {v1 .. v12}, Lcn/jpush/android/data/u;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIII)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :goto_9
    if-eqz v14, :cond_e

    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    :cond_e
    :goto_a
    invoke-virtual {v1}, Lcn/jpush/android/data/u;->b()V

    :cond_f
    move v1, v13

    :goto_b
    sget-object v2, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v3, 0x2c

    aget-object v2, v2, v3

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    return v1

    :cond_10
    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v8, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v10, 0x15

    aget-object v8, v8, v10

    invoke-direct {v2, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v8, 0x1a

    aget-object v2, v2, v8

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    goto/16 :goto_7

    :cond_11
    const/4 v7, 0x1

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v2, 0x2

    aget-object v1, v1, v2

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0x1c

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v3, 0x17

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v16

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto/16 :goto_8

    :cond_12
    :try_start_2
    invoke-static {}, Lcn/jpush/android/util/x;->e()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_9

    :catch_0
    move-exception v2

    move-object v2, v14

    :goto_c
    if-eqz v2, :cond_e

    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_a

    :catchall_0
    move-exception v1

    move-object v14, v2

    :goto_d
    if-eqz v14, :cond_13

    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    :cond_13
    throw v1

    :cond_14
    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0x24

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0x1b

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    invoke-static {}, Lcn/jpush/android/service/PushService;->b()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcn/jpush/android/util/a;->d()Ljava/lang/String;

    move-result-object v5

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v8, 0x1

    const/4 v12, 0x0

    move-object/from16 v2, v16

    move-object v3, v15

    invoke-virtual/range {v1 .. v12}, Lcn/jpush/android/data/u;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIII)J

    goto/16 :goto_a

    :cond_15
    const/4 v1, -0x1

    goto/16 :goto_b

    :catchall_1
    move-exception v1

    goto :goto_d

    :catch_1
    move-exception v3

    goto :goto_c
.end method


# virtual methods
.method public final run()V
    .locals 8

    const/16 v7, 0x270f

    const-wide/16 v5, 0x0

    const/4 v2, 0x0

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/jpush/android/service/n;->getId()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    iget-object v0, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-static {}, Lcn/jpush/android/service/PushService;->c()Z

    :try_start_0
    iget-object v0, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v0, v0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_0

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    iget-object v0, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v1, v1, Lcn/jpush/android/service/PushService;->v:I

    invoke-static {v1}, Lcn/jpush/android/service/PushProtocol;->Close(I)I

    move-result v1

    iput v1, v0, Lcn/jpush/android/service/PushService;->v:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v0}, Lcn/jpush/android/service/PushService;->d()V

    iget-object v0, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-static {}, Lcn/jpush/android/service/PushProtocol;->InitConn()I

    move-result v1

    iput v1, v0, Lcn/jpush/android/service/PushService;->v:I

    invoke-static {}, Lcn/jpush/android/service/PushService;->h()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v0

    if-eqz v0, :cond_1

    :try_start_2
    invoke-static {}, Lcn/jpush/android/service/PushService;->h()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/service/PushService;->e(Ljava/lang/String;)Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v2, 0xc

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcn/jpush/android/service/PushService;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v2, 0xa

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcn/jpush/android/service/PushService;->h()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V
    :try_end_2
    .catch Ljava/net/UnknownHostException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    :cond_1
    :goto_1
    :try_start_3
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v2, 0x6

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcn/jpush/android/service/PushService;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v2, 0x9

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcn/jpush/android/service/PushService;->j()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v0, v0, Lcn/jpush/android/service/PushService;->v:I

    invoke-static {}, Lcn/jpush/android/service/PushService;->i()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lcn/jpush/android/service/PushService;->j()I

    move-result v2

    invoke-static {v0, v1, v2}, Lcn/jpush/android/service/PushProtocol;->InitPush(ILjava/lang/String;I)I

    move-result v0

    if-eqz v0, :cond_3

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v2, 0x7

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/jpush/android/service/n;->getId()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v0, v0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_2

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    iget-object v0, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v1, v1, Lcn/jpush/android/service/PushService;->v:I

    invoke-static {v1}, Lcn/jpush/android/service/PushProtocol;->Close(I)I

    move-result v1

    iput v1, v0, Lcn/jpush/android/service/PushService;->v:I

    :cond_2
    iget-object v0, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/jpush/android/service/PushService;->f(I)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    :goto_2
    return-void

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto/16 :goto_0

    :cond_3
    :try_start_4
    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v2, 0x3

    aget-object v1, v1, v2

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-static {}, Lcn/jpush/android/service/PushService;->k()Z

    move-result v1

    if-nez v1, :cond_4

    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v1}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/service/PushService;->c(Landroid/content/Context;)Z

    move-result v1

    invoke-static {v1}, Lcn/jpush/android/service/PushService;->e(Z)Z

    :cond_4
    invoke-static {}, Lcn/jpush/android/service/PushService;->k()Z

    move-result v1

    if-eqz v1, :cond_5

    sget-wide v1, Lcn/jpush/android/service/PushService;->s:J

    cmp-long v1, v1, v5

    if-eqz v1, :cond_5

    sget-object v1, Lcn/jpush/android/service/PushService;->t:Ljava/lang/String;

    if-nez v1, :cond_6

    :cond_5
    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v1}, Lcn/jpush/android/service/PushService;->e()V

    :cond_6
    sget-wide v1, Lcn/jpush/android/service/PushService;->s:J

    cmp-long v1, v1, v5

    if-eqz v1, :cond_11

    invoke-direct {p0}, Lcn/jpush/android/service/n;->a()I

    move-result v0

    if-eqz v0, :cond_7

    if-ne v0, v7, :cond_f

    :cond_7
    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v2, 0x2

    aget-object v1, v1, v2

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v4, 0x5

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v3}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcn/jpush/android/util/a;->u(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcn/jpush/android/service/PushService;->a(Lcn/jpush/android/service/PushService;I)I

    invoke-static {}, Lcn/jpush/android/service/PushService;->l()Z

    move-result v1

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-static {v1}, Lcn/jpush/android/service/PushService;->a(Lcn/jpush/android/service/PushService;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    :cond_8
    :try_start_5
    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v1}, Lcn/jpush/android/service/PushService;->g()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    :goto_3
    if-ne v0, v7, :cond_9

    :try_start_6
    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    const/16 v2, 0x1770

    invoke-static {v1, v2}, Lcn/jpush/android/service/PushService;->b(Lcn/jpush/android/service/PushService;I)V

    :cond_9
    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    const/4 v2, 0x1

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0x8

    aget-object v3, v3, v4

    invoke-virtual {v1, v2, v3}, Lcn/jpush/android/service/PushService;->a(ILjava/lang/String;)V

    :goto_4
    iget-boolean v1, p0, Lcn/jpush/android/service/n;->c:Z

    if-nez v1, :cond_b

    iget-object v0, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v0, v0, Lcn/jpush/android/service/PushService;->v:I

    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget-object v1, v1, Lcn/jpush/android/service/PushService;->w:[B

    const v2, 0x15180

    invoke-static {v0, v1, v2}, Lcn/jpush/android/service/PushProtocol;->RecvPush(I[BI)I

    move-result v0

    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-lez v0, :cond_e

    invoke-static {}, Lcn/jpush/android/service/PushService;->l()Z

    move-result v1

    if-eqz v1, :cond_a

    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-static {v1}, Lcn/jpush/android/service/PushService;->a(Lcn/jpush/android/service/PushService;)V

    :cond_a
    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v1, v0}, Lcn/jpush/android/service/PushService;->e(I)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2

    :goto_5
    const-wide/16 v1, 0x64

    :try_start_7
    invoke-static {v1, v2}, Ljava/lang/Thread;->sleep(J)V
    :try_end_7
    .catch Ljava/lang/InterruptedException; {:try_start_7 .. :try_end_7} :catch_1
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_2

    goto :goto_4

    :catch_1
    move-exception v1

    :try_start_8
    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    :cond_b
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcn/jpush/android/service/n;->a:Z

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v3, 0xd

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/jpush/android/service/n;->getId()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    :cond_c
    :goto_6
    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v1, v1, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v1, :cond_d

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget-object v2, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v2, v2, Lcn/jpush/android/service/PushService;->v:I

    invoke-static {v2}, Lcn/jpush/android/service/PushProtocol;->Close(I)I

    move-result v2

    iput v2, v1, Lcn/jpush/android/service/PushService;->v:I

    :cond_d
    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v1, v0}, Lcn/jpush/android/service/PushService;->f(I)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_2

    goto/16 :goto_2

    :catch_2
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    goto/16 :goto_2

    :cond_e
    const/16 v1, -0x3e2

    if-ne v0, v1, :cond_b

    goto :goto_5

    :cond_f
    :try_start_9
    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v2, 0x2

    aget-object v1, v1, v2

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/16 v4, 0xb

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    iget v3, v3, Lcn/jpush/android/service/PushService;->v:I

    invoke-static {v3}, Lcn/jpush/android/service/PushProtocol;->GetEsg(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    if-lez v0, :cond_10

    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    invoke-virtual {v1}, Lcn/jpush/android/service/PushService;->f()V

    goto :goto_6

    :cond_10
    if-gez v0, :cond_c

    iget-object v1, p0, Lcn/jpush/android/service/n;->b:Lcn/jpush/android/service/PushService;

    const-wide/16 v2, 0x0

    invoke-static {v1, v2, v3}, Lcn/jpush/android/service/PushService;->a(Lcn/jpush/android/service/PushService;J)J

    goto :goto_6

    :cond_11
    sget-object v1, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v2, 0x2

    aget-object v1, v1, v2

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/n;->z:[Ljava/lang/String;

    const/4 v4, 0x4

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/jpush/android/service/n;->getId()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_2

    goto :goto_6

    :catch_3
    move-exception v1

    goto/16 :goto_3

    :catch_4
    move-exception v0

    goto/16 :goto_1
.end method
