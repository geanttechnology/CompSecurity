.class public final Lcn/jpush/android/data/c;
.super Landroid/database/sqlite/SQLiteOpenHelper;


# static fields
.field public static final a:[Ljava/lang/String;

.field public static final b:[Ljava/lang/String;

.field private static c:Lcn/jpush/android/data/c;

.field private static final z:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/16 v0, 0xd

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "m\u0017\"c\u0015hZm"

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

    const/16 v9, 0x7c

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

    const-string v1, "m\u0017\"c\u0015h"

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "a\u0006;R#e\u0003"

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "a\u00145c\u0015h"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, "y\u0017>U\u000fx"

    const/4 v0, 0x3

    move-object v3, v4

    goto :goto_0

    :pswitch_3
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "c\u00117N\u000ee\u00037c\u0015h"

    const/4 v0, 0x4

    move-object v3, v4

    goto :goto_0

    :pswitch_4
    aput-object v1, v3, v2

    const/4 v2, 0x6

    const-string v1, "\u007f\u0002 J\u0015o\u0002|X\u001e"

    const/4 v0, 0x5

    move-object v3, v4

    goto :goto_0

    :pswitch_5
    aput-object v1, v3, v2

    const/4 v2, 0x7

    const-string v1, "o\u00157]\u0008iG&]\u001e`\u0002rX\u0013{\t>U\u000fxO\rU\u0018,\u000e<H\u0019k\u0002 \u001c\u000c~\u000e?]\u000euG9Y\u0005,\u0006\'H\u0013e\t1N\u0019a\u0002<HPa\u00145c\u0015hG&Y\u0004xK Y\u000ci\u0006&c\u0012y\nrU\u0012x\u00025Y\u000e \u0014&]\u000ex8\"S\u000f,\u000e<H\u0019k\u0002 \u0010\u0019b\u0003\rL\u0013\u007fG;R\u0008i\u00007NPo\u0008<H\u0019b\u0013rH\u0019t\u0013{"

    const/4 v0, 0x6

    move-object v3, v4

    goto :goto_0

    :pswitch_6
    aput-object v1, v3, v2

    const/16 v2, 0x8

    const-string v1, "o\u00157]\u0008iG&]\u001e`\u0002rI\u000c`\u000e!HTS\u000e6\u001c\u0015b\u00137[\u0019~G\"N\u0015a\u0006 E\\g\u0002+\u001c\u001dy\u0013=U\u0012o\u00157Q\u0019b\u0013~Q\u000fk8;X\\x\u0002*HPm\u0017\"c\u0015hG&Y\u0004xK?]\u0015b8;X\\x\u0002*HP,\u0008$Y\u000e~\u000e6Y#e\u0003rH\u0019t\u0013{"

    const/4 v0, 0x7

    move-object v3, v4

    goto :goto_0

    :pswitch_7
    aput-object v1, v3, v2

    const/16 v2, 0x9

    const-string v1, "X\u000f7\u001c\u0013`\u0003\u0004Y\u000e\u007f\u000e=R\\e\u0014h\u001c"

    const/16 v0, 0x8

    move-object v3, v4

    goto :goto_0

    :pswitch_8
    aput-object v1, v3, v2

    const/16 v2, 0xa

    const-string v1, "h\u0015=L\\x\u00060P\u0019,\u0003=K\u0012`\u000e!H"

    const/16 v0, 0x9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9
    aput-object v1, v3, v2

    const/16 v2, 0xb

    const-string v1, "h\u0015=L\\x\u00060P\u0019,\u0012\"P\u0015\u007f\u0013"

    const/16 v0, 0xa

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a
    aput-object v1, v3, v2

    const/16 v2, 0xc

    const-string v1, ",\u0013:Y\\b\u0002%j\u0019~\u0014;S\u0012,\u000e!\u001cF,"

    const/16 v0, 0xb

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v0, 0x6

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "S\u000e6"

    const/16 v0, 0xc

    move-object v4, v3

    goto/16 :goto_0

    :pswitch_c
    const/16 v9, 0xc

    goto/16 :goto_2

    :pswitch_d
    const/16 v9, 0x67

    goto/16 :goto_2

    :pswitch_e
    const/16 v9, 0x52

    goto/16 :goto_2

    :pswitch_f
    const/16 v9, 0x3c

    goto/16 :goto_2

    :pswitch_10
    aput-object v1, v3, v2

    const/4 v0, 0x1

    sget-object v1, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v2, 0x3

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/4 v2, 0x2

    const-string v1, "~\u0002\"Y\u001dx8<I\u0011"

    const/16 v0, 0xd

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_11
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "\u007f\u00133N\u0008S\u0017=O"

    const/16 v0, 0xe

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_12
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, "i\t6c\u000cc\u0014"

    const/16 v0, 0xf

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_13
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "o\u0008<H\u0019b\u0013"

    const/16 v0, 0x10

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_14
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/data/c;->a:[Ljava/lang/String;

    const/4 v0, 0x4

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "S\u000e6"

    const/16 v0, 0x11

    move-object v4, v3

    goto/16 :goto_0

    :pswitch_15
    aput-object v1, v3, v2

    const/4 v0, 0x1

    sget-object v1, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v2, 0x3

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/4 v0, 0x2

    sget-object v1, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    const/4 v0, 0x3

    sget-object v1, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v2, 0x2

    aget-object v1, v1, v2

    aput-object v1, v4, v0

    sput-object v4, Lcn/jpush/android/data/c;->b:[Ljava/lang/String;

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
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
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
    .end packed-switch
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 3

    sget-object v0, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v1, 0x6

    aget-object v0, v0, v1

    const/4 v1, 0x0

    const/4 v2, 0x3

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    return-void
.end method

.method private static a(Landroid/content/Context;)Lcn/jpush/android/data/c;
    .locals 1

    sget-object v0, Lcn/jpush/android/data/c;->c:Lcn/jpush/android/data/c;

    if-nez v0, :cond_0

    new-instance v0, Lcn/jpush/android/data/c;

    invoke-direct {v0, p0}, Lcn/jpush/android/data/c;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcn/jpush/android/data/c;->c:Lcn/jpush/android/data/c;

    :cond_0
    sget-object v0, Lcn/jpush/android/data/c;->c:Lcn/jpush/android/data/c;

    return-object v0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 14

    const/4 v8, 0x0

    invoke-static {p0}, Lcn/jpush/android/data/c;->a(Landroid/content/Context;)Lcn/jpush/android/data/c;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/data/c;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v9, ""

    const-string v12, ""

    const-string v11, ""

    const-string v10, ""

    :try_start_0
    sget-object v1, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v2, 0x4

    aget-object v1, v1, v2

    sget-object v2, Lcn/jpush/android/data/c;->b:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    if-eqz v1, :cond_3

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-ltz v2, :cond_3

    :cond_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_3

    sget-object v2, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v3, 0x1

    aget-object v2, v2, v3

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    sget-object v2, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x3

    aget-object v2, v2, v4

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    sget-object v2, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x2

    aget-object v2, v2, v4

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    sget-object v2, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v6, 0x5

    aget-object v2, v2, v6

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v3}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v6

    if-eqz v6, :cond_0

    move-object v13, v2

    move-object v2, v5

    move-object v5, v4

    move-object v4, v3

    move-object v3, v13

    :goto_0
    :try_start_2
    sget-object v6, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v7, 0x4

    aget-object v6, v6, v7

    sget-object v7, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v8, 0x0

    aget-object v7, v7, v8

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    aput-object v4, v8, v9

    invoke-virtual {v0, v6, v7, v8}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ","

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ","

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v0

    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_1
    :goto_1
    return-object v0

    :catch_0
    move-exception v0

    move-object v1, v8

    move-object v0, v9

    :goto_2
    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_1

    :catchall_0
    move-exception v0

    move-object v1, v8

    :goto_3
    if-eqz v1, :cond_2

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    :catchall_1
    move-exception v0

    goto :goto_3

    :catch_1
    move-exception v0

    move-object v0, v9

    goto :goto_2

    :catch_2
    move-exception v0

    move-object v0, v2

    goto :goto_2

    :cond_3
    move-object v3, v10

    move-object v4, v11

    move-object v5, v12

    move-object v2, v9

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Lcn/jpush/android/data/d;Ljava/lang/String;Ljava/lang/String;)V
    .locals 11

    const/4 v8, 0x0

    iget-object v9, p1, Lcn/jpush/android/data/d;->c:Ljava/lang/String;

    iget-object v10, p1, Lcn/jpush/android/data/d;->d:Ljava/lang/String;

    invoke-static {p0}, Lcn/jpush/android/data/c;->a(Landroid/content/Context;)Lcn/jpush/android/data/c;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/data/c;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    :try_start_0
    sget-object v1, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v2, 0x4

    aget-object v1, v1, v2

    sget-object v2, Lcn/jpush/android/data/c;->b:[Ljava/lang/String;

    sget-object v3, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x0

    aget-object v3, v3, v4

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p2, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    if-eqz v1, :cond_0

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-gtz v2, :cond_2

    :cond_0
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    sget-object v3, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x3

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v3, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x1

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v3, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x2

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v3, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x5

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v3, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x4

    aget-object v3, v3, v4

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4, v2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :goto_0
    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_1
    :goto_1
    return-void

    :cond_2
    :try_start_2
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    sget-object v3, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x3

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v3, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x2

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v3, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x5

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v3, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v4, 0x4

    aget-object v3, v3, v4

    sget-object v4, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p2, v5, v6

    invoke-virtual {v0, v3, v2, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_0

    :catch_0
    move-exception v0

    move-object v0, v1

    :goto_2
    if-eqz v0, :cond_1

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1

    :catchall_0
    move-exception v0

    move-object v1, v8

    :goto_3
    if-eqz v1, :cond_3

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v0

    :catchall_1
    move-exception v0

    goto :goto_3

    :catch_1
    move-exception v0

    move-object v0, v8

    goto :goto_2
.end method


# virtual methods
.method public final onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/4 v1, 0x7

    aget-object v0, v0, v1

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    sget-object v0, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/16 v1, 0x8

    aget-object v0, v0, v1

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    return-void
.end method

.method public final onDowngrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 4

    const/16 v3, 0xb

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v3, :cond_0

    invoke-super {p0, p1, p2, p3}, Landroid/database/sqlite/SQLiteOpenHelper;->onDowngrade(Landroid/database/sqlite/SQLiteDatabase;II)V

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/16 v2, 0x9

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/16 v2, 0xc

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/16 v1, 0xa

    aget-object v0, v0, v1

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    sget-object v0, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    aget-object v0, v0, v3

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lcn/jpush/android/data/c;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    return-void
.end method

.method public final onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/16 v2, 0x9

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/16 v2, 0xc

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/16 v1, 0xa

    aget-object v0, v0, v1

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    sget-object v0, Lcn/jpush/android/data/c;->z:[Ljava/lang/String;

    const/16 v1, 0xb

    aget-object v0, v0, v1

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lcn/jpush/android/data/c;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    return-void
.end method
