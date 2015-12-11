.class public final Lcn/jpush/android/data/u;
.super Ljava/lang/Object;


# static fields
.field public static final a:[Ljava/lang/String;

.field private static final z:[Ljava/lang/String;


# instance fields
.field private b:Landroid/content/Context;

.field private c:Lcn/jpush/android/data/v;

.field private d:Landroid/database/sqlite/SQLiteDatabase;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/16 v0, 0x13

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "8\u0017\u0005\u001e\u00049R\u000f\t\u001f1R\u0003\u000b\u0005/\u001a6\u0008\u0004=\u0006\u0000\u0008\u00045\u0011\u001a"

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

    const/16 v9, 0x70

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

    const-string v1, "/\u0017\u0005\u001e\u0013(R*4%\u0012&A\u0008\u0004\u0003\u0001\u0006\t\u0004\u0003\u0019\u000c\u0002Y|\u0014\u001b\u0014\u001d|\u0018\u0019\u000e\u00034-\u001a\u000f\u0011(\u001b\u001a\u000f\u0019?\u0001I\u000c\u00189\u0000\u000c[\u0003(-\u001a\u0014\u0002(-\u0002\u001e\t|OID"

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "/\u0017\u0005\u001e\u0013(RC[\u0016.\u001d\u0004[\u001a,\u0007\u001a\u0013//\u0006\u0008\u000f\u0019/\u0006\u0000\u0018\u0003|\u0005\u0001\u001e\u00029R\u001a\u000f/:\u0013\u0000\u0017\u00158RW[@|R\u0006\t\u00149\u0000I\u0019\t|\u0001\u001d$\u0016=\u001b\u0005\u001e\u0014|\u0016\u000c\u0008\u0013|\u001e\u0000\u0016\u0019(RZ"

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "/\u0017\u0005\u001e\u0013(RC[\u0016.\u001d\u0004[\u001a,\u0007\u001a\u0013//\u0006\u0008\u000f\u0019/\u0006\u0000\u0018\u0003|\u0005\u0001\u001e\u00029R\u001a\u000f/(\u001d\u001d\u001a\u001c|LIKP=\u001c\r[\u0003(-\u000f\u001a\u00190\u0017\r[M|BI[\u001f.\u0016\u000c\tP>\u000bI\u0008\u0004\u0003\u0006\u0006\u000f\u00110R\r\u001e\u0003?R\u0005\u0012\u001d5\u0006IH"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, "/\u00066\u001d\u00115\u001e\u000c\u001f"

    const/4 v0, 0x3

    move-object v3, v4

    goto :goto_0

    :pswitch_3
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "uR\u000f\t\u001f1R\u0003\u000b\u0005/\u001a6\u0008\u0004=\u0006\u0000\u0008\u00045\u0011\u001a"

    const/4 v0, 0x4

    move-object v3, v4

    goto :goto_0

    :pswitch_4
    aput-object v1, v3, v2

    const/4 v2, 0x6

    const-string v1, "/\u0017\u0005\u001e\u0013(R:.=t"

    const/4 v0, 0x5

    move-object v3, v4

    goto :goto_0

    :pswitch_5
    aput-object v1, v3, v2

    const/4 v2, 0x7

    const-string v1, "/\u00066\u000f\u001f(\u0013\u0005"

    const/4 v0, 0x6

    move-object v3, v4

    goto :goto_0

    :pswitch_6
    aput-object v1, v3, v2

    const/16 v2, 0x8

    const-string v1, "6\u0002\u001c\u0008\u0018\u0003\u0001\u001d\u001a\u00045\u0001\u001d\u0012\u0013/"

    const/4 v0, 0x7

    move-object v3, v4

    goto :goto_0

    :pswitch_7
    aput-object v1, v3, v2

    const/16 v2, 0x9

    const-string v1, "/\u00066\u0008\u001f.\u00066\u0010\u0015%ON"

    const/16 v0, 0x8

    move-object v3, v4

    goto :goto_0

    :pswitch_8
    aput-object v1, v3, v2

    const/16 v2, 0xa

    const-string v1, "/\u00066\u0008\u001f)\u0000\n\u001e"

    const/16 v0, 0x9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9
    aput-object v1, v3, v2

    const/16 v2, 0xb

    const-string v1, "/\u00066\u0015\u0015("

    const/16 v0, 0xa

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a
    aput-object v1, v3, v2

    const/16 v2, 0xc

    const-string v1, "/\u00066\u0018\u001f)\u001c\u001d$A"

    const/16 v0, 0xb

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b
    aput-object v1, v3, v2

    const/16 v2, 0xd

    const-string v1, "/\u00066\u0018\u001f)\u001c\u001d$C\u0003CY"

    const/16 v0, 0xc

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c
    aput-object v1, v3, v2

    const/16 v2, 0xe

    const-string v1, "/\u00066\u0018\u001f)\u001c\u001d$Al"

    const/16 v0, 0xd

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d
    aput-object v1, v3, v2

    const/16 v2, 0xf

    const-string v1, "/\u00066\u0018\u001f)\u001c\u001d$A\u0003A"

    const/16 v0, 0xe

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_e
    aput-object v1, v3, v2

    const/16 v2, 0x10

    const-string v1, "/\u00066\u0017\u001f?\u0013\u0005$\u00142\u0001"

    const/16 v0, 0xf

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_f
    aput-object v1, v3, v2

    const/16 v2, 0x11

    const-string v1, "/\u00066\u0018\u001f2\u001c6\u0012\u0000"

    const/16 v0, 0x10

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_10
    aput-object v1, v3, v2

    const/16 v2, 0x12

    const-string v1, "/\u00066\u0008\u001f.\u00066\u0010\u0015%"

    const/16 v0, 0x11

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_11
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v0, 0xc

    new-array v3, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0x12

    aget-object v1, v1, v2

    aput-object v1, v3, v0

    const/4 v2, 0x1

    const-string v1, "\u0003\u001b\r"

    const/16 v0, 0x12

    move-object v4, v3

    goto/16 :goto_0

    :pswitch_12
    const/16 v9, 0x5c

    goto/16 :goto_2

    :pswitch_13
    const/16 v9, 0x72

    goto/16 :goto_2

    :pswitch_14
    const/16 v9, 0x69

    goto/16 :goto_2

    :pswitch_15
    const/16 v9, 0x7b

    goto/16 :goto_2

    :pswitch_16
    aput-object v1, v3, v2

    const/4 v0, 0x2

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xb

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/4 v0, 0x3

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0x11

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/4 v0, 0x4

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0x10

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/4 v0, 0x5

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xa

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/4 v0, 0x6

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v2, 0x4

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/4 v0, 0x7

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v2, 0x7

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/16 v0, 0x8

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xc

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/16 v0, 0x9

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xf

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/16 v0, 0xa

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xd

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/16 v0, 0xb

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xe

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    sput-object v4, Lcn/jpush/android/data/u;->a:[Ljava/lang/String;

    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
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
        :pswitch_16
    .end packed-switch
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcn/jpush/android/data/u;->b:Landroid/content/Context;

    return-void
.end method

.method public static a(Landroid/database/Cursor;)Lcn/jpush/android/data/w;
    .locals 2

    if-eqz p0, :cond_0

    invoke-interface {p0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Lcn/jpush/android/data/w;

    invoke-direct {v0}, Lcn/jpush/android/data/w;-><init>()V

    const/4 v1, 0x1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->a(Ljava/lang/String;)V

    const/4 v1, 0x2

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->b(Ljava/lang/String;)V

    const/4 v1, 0x3

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->c(Ljava/lang/String;)V

    const/4 v1, 0x4

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->d(Ljava/lang/String;)V

    const/4 v1, 0x5

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->e(Ljava/lang/String;)V

    const/4 v1, 0x6

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->a(I)V

    const/4 v1, 0x7

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->b(I)V

    const/16 v1, 0x8

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->c(I)V

    const/16 v1, 0x9

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->d(I)V

    const/16 v1, 0xa

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->e(I)V

    const/16 v1, 0xb

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/w;->f(I)V

    invoke-virtual {v0}, Lcn/jpush/android/data/w;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    goto :goto_0
.end method


# virtual methods
.method public final a(Z)I
    .locals 5

    const/4 v1, 0x0

    sget-object v0, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v2, 0x4

    aget-object v0, v0, v2

    if-eqz p1, :cond_0

    sget-object v0, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v2, 0x7

    aget-object v0, v0, v2

    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v4, 0x6

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIII)J
    .locals 4

    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0x12

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xb

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0x11

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0x10

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xa

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v2, 0x4

    aget-object v1, v1, v2

    invoke-static {p6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v2, 0x7

    aget-object v1, v1, v2

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xc

    aget-object v1, v1, v2

    invoke-static {p8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xf

    aget-object v1, v1, v2

    invoke-static {p9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xd

    aget-object v1, v1, v2

    invoke-static {p10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0xe

    aget-object v1, v1, v2

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    iget-object v1, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    return-wide v0
.end method

.method public final a()V
    .locals 2

    new-instance v0, Lcn/jpush/android/data/v;

    iget-object v1, p0, Lcn/jpush/android/data/u;->b:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcn/jpush/android/data/v;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcn/jpush/android/data/u;->c:Lcn/jpush/android/data/v;

    :try_start_0
    iget-object v0, p0, Lcn/jpush/android/data/u;->c:Lcn/jpush/android/data/v;

    invoke-virtual {v0}, Lcn/jpush/android/data/v;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    iget-object v0, p0, Lcn/jpush/android/data/u;->c:Lcn/jpush/android/data/v;

    invoke-virtual {v0}, Lcn/jpush/android/data/v;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;)Z
    .locals 5

    const/4 v1, 0x1

    const/4 v0, 0x0

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    aget-object v2, v2, v1

    new-array v3, v1, [Ljava/lang/String;

    aput-object p1, v3, v0

    iget-object v4, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v4, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    invoke-interface {v2, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    if-nez v2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method public final b(Ljava/lang/String;)Landroid/database/Cursor;
    .locals 10

    const/4 v5, 0x0

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0x9

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iget-object v0, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v1, 0x1

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    sget-object v3, Lcn/jpush/android/data/u;->a:[Ljava/lang/String;

    move-object v6, v5

    move-object v7, v5

    move-object v8, v5

    move-object v9, v5

    invoke-virtual/range {v0 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    :cond_0
    return-object v0
.end method

.method public final b()V
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    return-void
.end method

.method public final b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIII)Z
    .locals 5

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v2, 0x9

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0x12

    aget-object v2, v2, v3

    invoke-virtual {v1, v2, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0xb

    aget-object v2, v2, v3

    invoke-virtual {v1, v2, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0x11

    aget-object v2, v2, v3

    invoke-virtual {v1, v2, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0x10

    aget-object v2, v2, v3

    invoke-virtual {v1, v2, p4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0xa

    aget-object v2, v2, v3

    invoke-virtual {v1, v2, p5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v3, 0x4

    aget-object v2, v2, v3

    invoke-static {p6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v3, 0x7

    aget-object v2, v2, v3

    invoke-static {p7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0xc

    aget-object v2, v2, v3

    invoke-static {p8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0xf

    aget-object v2, v2, v3

    invoke-static {p9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0xd

    aget-object v2, v2, v3

    invoke-static {p10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    sget-object v2, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v3, 0xe

    aget-object v2, v2, v3

    invoke-static/range {p11 .. p11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    iget-object v2, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;

    sget-object v3, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/16 v4, 0x8

    aget-object v3, v3, v4

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v1, v0, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final c()V
    .locals 2

    sget-object v0, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    iget-object v1, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    return-void
.end method

.method public final d()Landroid/database/Cursor;
    .locals 3

    sget-object v0, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v1, 0x2

    aget-object v0, v0, v1

    iget-object v1, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    :cond_0
    return-object v0
.end method

.method public final e()Landroid/database/Cursor;
    .locals 3

    sget-object v0, Lcn/jpush/android/data/u;->z:[Ljava/lang/String;

    const/4 v1, 0x3

    aget-object v0, v0, v1

    iget-object v1, p0, Lcn/jpush/android/data/u;->d:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    :cond_0
    return-object v0
.end method
