.class public final Lcom/wishabi/flipp/app/fp;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Landroid/app/FragmentManager;)I
    .locals 11

    .prologue
    const/4 v1, 0x0

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 45
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v0

    .line 46
    if-nez v0, :cond_0

    .line 47
    sget v0, Lcom/wishabi/flipp/app/fq;->c:I

    .line 60
    :goto_0
    return v0

    .line 49
    :cond_0
    new-instance v3, Lcom/wishabi/flipp/content/FormattedString;

    const/4 v2, 0x3

    new-array v2, v2, [Lcom/wishabi/flipp/content/FormattedString$Part;

    new-instance v4, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v5, 0x7f0e0146

    invoke-virtual {v0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    new-array v6, v10, [Lcom/wishabi/flipp/content/FormattedString$Format;

    new-instance v7, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v8, Lcom/wishabi/flipp/content/ab;->a:I

    invoke-direct {v7, v8}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v7, v6, v9

    invoke-direct {v4, v5, v6}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v4, v2, v9

    new-instance v4, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v5, 0x7f0e0147

    invoke-virtual {v0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    new-array v6, v10, [Lcom/wishabi/flipp/content/FormattedString$Format;

    new-instance v7, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v8, Lcom/wishabi/flipp/content/ab;->b:I

    invoke-direct {v7, v8}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v7, v6, v9

    invoke-direct {v4, v5, v6}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v4, v2, v10

    const/4 v4, 0x2

    new-instance v5, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v6, 0x7f0e0148

    invoke-virtual {v0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-array v6, v10, [Lcom/wishabi/flipp/content/FormattedString$Format;

    new-instance v7, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v8, Lcom/wishabi/flipp/content/ab;->a:I

    invoke-direct {v7, v8}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v7, v6, v9

    invoke-direct {v5, v0, v6}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v5, v2, v4

    invoke-direct {v3, v2}, Lcom/wishabi/flipp/content/FormattedString;-><init>([Lcom/wishabi/flipp/content/FormattedString$Part;)V

    .line 60
    const-string v2, "tutorial_showed_coupon_badge"

    const v4, 0x7f0200f4

    const v5, 0x7f0200f8

    move-object v0, p0

    move-object v6, v1

    invoke-static/range {v0 .. v6}, Lcom/wishabi/flipp/app/fp;->a(Landroid/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/wishabi/flipp/content/FormattedString;IILcom/wishabi/flipp/app/dq;)I

    move-result v0

    goto :goto_0
.end method

.method static a(Landroid/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/wishabi/flipp/content/FormattedString;IILcom/wishabi/flipp/app/dq;)I
    .locals 2

    .prologue
    .line 21
    if-nez p0, :cond_0

    .line 22
    sget v0, Lcom/wishabi/flipp/app/fq;->c:I

    .line 39
    :goto_0
    return v0

    .line 24
    :cond_0
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 25
    if-nez v0, :cond_1

    .line 26
    sget v0, Lcom/wishabi/flipp/app/fq;->c:I

    goto :goto_0

    .line 28
    :cond_1
    const/4 v1, 0x0

    invoke-interface {v0, p2, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 29
    if-eqz v1, :cond_2

    .line 30
    sget v0, Lcom/wishabi/flipp/app/fq;->a:I

    goto :goto_0

    .line 32
    :cond_2
    invoke-static {p3, p4, p5}, Lcom/wishabi/flipp/app/fn;->a(Lcom/wishabi/flipp/content/FormattedString;II)Lcom/wishabi/flipp/app/fn;

    move-result-object v1

    .line 34
    iput-object p6, v1, Lcom/wishabi/flipp/app/dp;->a:Lcom/wishabi/flipp/app/dq;

    .line 35
    invoke-virtual {v1, p0, p1}, Lcom/wishabi/flipp/app/fn;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 37
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, p2, v1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 39
    sget v0, Lcom/wishabi/flipp/app/fq;->b:I

    goto :goto_0
.end method
