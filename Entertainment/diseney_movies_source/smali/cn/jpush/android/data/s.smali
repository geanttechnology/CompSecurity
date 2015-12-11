.class public final Lcn/jpush/android/data/s;
.super Lcn/jpush/android/data/d;


# static fields
.field private static final bb:[Ljava/lang/String;


# instance fields
.field public W:I

.field public X:Z

.field public Y:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public Z:Ljava/lang/String;

.field public a:Ljava/lang/String;

.field public aa:Ljava/lang/String;

.field public ab:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/4 v0, 0x6

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "J\u0016D6\"S"

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

    const/16 v9, 0x57

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

    const-string v1, "[&n*;"

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "[&~*2M"

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "[&h08I"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, "[&i=$"

    const/4 v0, 0x3

    move-object v3, v4

    goto :goto_0

    :pswitch_3
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "X\u000bt5\u0008P\u000cv"

    const/4 v0, 0x4

    move-object v3, v4

    goto :goto_0

    :pswitch_4
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/data/s;->bb:[Ljava/lang/String;

    return-void

    :pswitch_5
    const/16 v9, 0x3e

    goto :goto_2

    :pswitch_6
    const/16 v9, 0x79

    goto :goto_2

    :pswitch_7
    const/16 v9, 0x1b

    goto :goto_2

    :pswitch_8
    const/16 v9, 0x58

    goto :goto_2

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcn/jpush/android/data/d;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/jpush/android/data/s;->Y:Ljava/util/ArrayList;

    const-string v0, ""

    iput-object v0, p0, Lcn/jpush/android/data/s;->Z:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/jpush/android/data/s;->aa:Ljava/lang/String;

    const/4 v0, 0x0

    iput v0, p0, Lcn/jpush/android/data/s;->o:I

    return-void
.end method


# virtual methods
.method public final a(Landroid/content/Context;)V
    .locals 1

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    new-instance v0, Lcn/jpush/android/data/t;

    invoke-direct {v0, p0, p1, p0}, Lcn/jpush/android/data/t;-><init>(Lcn/jpush/android/data/s;Landroid/content/Context;Lcn/jpush/android/data/s;)V

    invoke-virtual {v0}, Lcn/jpush/android/data/t;->start()V

    return-void
.end method

.method public final a(Landroid/content/Context;Lorg/json/JSONObject;)Z
    .locals 4

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    sget-object v0, Lcn/jpush/android/data/s;->bb:[Ljava/lang/String;

    aget-object v0, v0, v1

    const-string v3, ""

    invoke-virtual {p2, v0, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcn/jpush/android/data/s;->a:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/data/s;->bb:[Ljava/lang/String;

    const/4 v3, 0x3

    aget-object v0, v0, v3

    invoke-virtual {p2, v0, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcn/jpush/android/data/s;->W:I

    sget-object v0, Lcn/jpush/android/data/s;->bb:[Ljava/lang/String;

    const/4 v3, 0x4

    aget-object v0, v0, v3

    invoke-virtual {p2, v0, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lcn/jpush/android/data/s;->X:Z

    iget-boolean v0, p0, Lcn/jpush/android/data/s;->X:Z

    if-eqz v0, :cond_0

    sget-object v0, Lcn/jpush/android/data/s;->bb:[Ljava/lang/String;

    const/4 v3, 0x2

    aget-object v0, v0, v3

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/h;->a(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcn/jpush/android/data/s;->Y:Ljava/util/ArrayList;

    :cond_0
    sget-object v0, Lcn/jpush/android/data/s;->bb:[Ljava/lang/String;

    const/4 v3, 0x5

    aget-object v0, v0, v3

    const-string v3, ""

    invoke-virtual {p2, v0, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcn/jpush/android/data/s;->Z:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/data/s;->bb:[Ljava/lang/String;

    aget-object v0, v0, v2

    const-string v2, ""

    invoke-virtual {p2, v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcn/jpush/android/data/s;->aa:Ljava/lang/String;

    return v1

    :cond_1
    move v0, v2

    goto :goto_0
.end method
