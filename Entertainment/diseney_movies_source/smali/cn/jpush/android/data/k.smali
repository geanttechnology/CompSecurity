.class public final Lcn/jpush/android/data/k;
.super Ljava/lang/Object;


# static fields
.field private static final z:[Ljava/lang/String;


# instance fields
.field private a:I

.field private b:I

.field private c:I

.field private d:I

.field private e:Ljava/lang/String;

.field private f:J

.field private g:J


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/4 v0, 0x7

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "\u007f1f\u0003S0~\u007f\u0003xn"

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

    const/16 v9, 0xc

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

    const-string v1, "\u007f1f\u0003S6i~\u001fmn"

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "\u001f~i\u000c`\u001d~~\u0004j:rk\u0019e<\u007fN/H2ekMW?\u007fU\u0004hn"

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "\u007f1f\u0003S2un2x:|oP"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, "\u007f1f\u0003S\'hz\u00081"

    const/4 v0, 0x3

    move-object v3, v4

    goto :goto_0

    :pswitch_3
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "\u007f1f\u0003S\'cc\nk6cU\u0019e>t7"

    const/4 v0, 0x4

    move-object v3, v4

    goto :goto_0

    :pswitch_4
    aput-object v1, v3, v2

    const/4 v2, 0x6

    const-string v1, "\u007f1f\u0003S!tg\u0002z6,"

    const/4 v0, 0x5

    move-object v3, v4

    goto :goto_0

    :pswitch_5
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/data/k;->z:[Ljava/lang/String;

    return-void

    :pswitch_6
    const/16 v9, 0x53

    goto :goto_2

    :pswitch_7
    const/16 v9, 0x11

    goto :goto_2

    :pswitch_8
    const/16 v9, 0xa

    goto :goto_2

    :pswitch_9
    const/16 v9, 0x6d

    goto :goto_2

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public constructor <init>()V
    .locals 4

    const-wide/16 v2, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v1, p0, Lcn/jpush/android/data/k;->a:I

    iput v1, p0, Lcn/jpush/android/data/k;->b:I

    iput v1, p0, Lcn/jpush/android/data/k;->c:I

    iput v1, p0, Lcn/jpush/android/data/k;->d:I

    const-string v0, ""

    iput-object v0, p0, Lcn/jpush/android/data/k;->e:Ljava/lang/String;

    iput-wide v2, p0, Lcn/jpush/android/data/k;->f:J

    iput-wide v2, p0, Lcn/jpush/android/data/k;->g:J

    iput v1, p0, Lcn/jpush/android/data/k;->a:I

    iput v1, p0, Lcn/jpush/android/data/k;->b:I

    iput v1, p0, Lcn/jpush/android/data/k;->c:I

    iput v1, p0, Lcn/jpush/android/data/k;->d:I

    const-string v0, ""

    iput-object v0, p0, Lcn/jpush/android/data/k;->e:Ljava/lang/String;

    iput-wide v2, p0, Lcn/jpush/android/data/k;->f:J

    iput-wide v2, p0, Lcn/jpush/android/data/k;->g:J

    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    iget v0, p0, Lcn/jpush/android/data/k;->a:I

    return v0
.end method

.method public final a(I)V
    .locals 0

    iput p1, p0, Lcn/jpush/android/data/k;->a:I

    return-void
.end method

.method public final a(J)V
    .locals 0

    iput-wide p1, p0, Lcn/jpush/android/data/k;->g:J

    return-void
.end method

.method public final a(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcn/jpush/android/data/k;->e:Ljava/lang/String;

    return-void
.end method

.method public final b()I
    .locals 1

    iget v0, p0, Lcn/jpush/android/data/k;->b:I

    return v0
.end method

.method public final b(I)V
    .locals 0

    iput p1, p0, Lcn/jpush/android/data/k;->b:I

    return-void
.end method

.method public final b(J)V
    .locals 0

    iput-wide p1, p0, Lcn/jpush/android/data/k;->f:J

    return-void
.end method

.method public final c()I
    .locals 1

    iget v0, p0, Lcn/jpush/android/data/k;->c:I

    return v0
.end method

.method public final c(I)V
    .locals 0

    iput p1, p0, Lcn/jpush/android/data/k;->c:I

    return-void
.end method

.method public final d()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/data/k;->e:Ljava/lang/String;

    return-object v0
.end method

.method public final d(I)V
    .locals 0

    iput p1, p0, Lcn/jpush/android/data/k;->d:I

    return-void
.end method

.method public final e()J
    .locals 2

    iget-wide v0, p0, Lcn/jpush/android/data/k;->g:J

    return-wide v0
.end method

.method public final f()J
    .locals 2

    iget-wide v0, p0, Lcn/jpush/android/data/k;->f:J

    return-wide v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/data/k;->z:[Ljava/lang/String;

    const/4 v2, 0x2

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Lcn/jpush/android/data/k;->a:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/data/k;->z:[Ljava/lang/String;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcn/jpush/android/data/k;->b:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/data/k;->z:[Ljava/lang/String;

    const/4 v2, 0x6

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcn/jpush/android/data/k;->c:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/data/k;->z:[Ljava/lang/String;

    const/4 v2, 0x4

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcn/jpush/android/data/k;->d:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/data/k;->z:[Ljava/lang/String;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcn/jpush/android/data/k;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/data/k;->z:[Ljava/lang/String;

    const/4 v2, 0x5

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lcn/jpush/android/data/k;->f:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/data/k;->z:[Ljava/lang/String;

    const/4 v2, 0x3

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lcn/jpush/android/data/k;->g:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
