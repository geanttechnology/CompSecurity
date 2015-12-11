.class public Llo;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Landroid/graphics/Typeface;

.field public static b:Landroid/graphics/Typeface;

.field public static c:Landroid/graphics/Typeface;

.field public static d:Landroid/graphics/Typeface;

.field public static e:Landroid/graphics/Typeface;


# direct methods
.method public static a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;
    .locals 2

    .prologue
    .line 42
    invoke-static {p0, p2}, Llo;->a(Landroid/content/Context;Landroid/content/res/Resources;)V

    .line 43
    const/4 v0, 0x0

    .line 44
    const v1, 0x7f080021

    if-ne p1, v1, :cond_1

    .line 45
    sget-object v0, Llo;->a:Landroid/graphics/Typeface;

    .line 55
    :cond_0
    :goto_0
    return-object v0

    .line 46
    :cond_1
    const v1, 0x7f080020

    if-ne p1, v1, :cond_2

    .line 47
    sget-object v0, Llo;->b:Landroid/graphics/Typeface;

    goto :goto_0

    .line 48
    :cond_2
    const v1, 0x7f080024

    if-ne p1, v1, :cond_3

    .line 49
    sget-object v0, Llo;->c:Landroid/graphics/Typeface;

    goto :goto_0

    .line 50
    :cond_3
    const v1, 0x7f080022

    if-ne p1, v1, :cond_4

    .line 51
    sget-object v0, Llo;->d:Landroid/graphics/Typeface;

    goto :goto_0

    .line 52
    :cond_4
    const v1, 0x7f080023

    if-ne p1, v1, :cond_0

    .line 53
    sget-object v0, Llo;->e:Landroid/graphics/Typeface;

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Landroid/content/res/Resources;)V
    .locals 2

    .prologue
    .line 21
    sget-object v0, Llo;->a:Landroid/graphics/Typeface;

    if-nez v0, :cond_0

    .line 22
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const v1, 0x7f080021

    invoke-virtual {p1, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Llo;->a:Landroid/graphics/Typeface;

    .line 25
    :cond_0
    sget-object v0, Llo;->b:Landroid/graphics/Typeface;

    if-nez v0, :cond_1

    .line 26
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const v1, 0x7f080020

    invoke-virtual {p1, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Llo;->b:Landroid/graphics/Typeface;

    .line 29
    :cond_1
    sget-object v0, Llo;->c:Landroid/graphics/Typeface;

    if-nez v0, :cond_2

    .line 30
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const v1, 0x7f080024

    invoke-virtual {p1, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Llo;->c:Landroid/graphics/Typeface;

    .line 33
    :cond_2
    sget-object v0, Llo;->d:Landroid/graphics/Typeface;

    if-nez v0, :cond_3

    .line 34
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const v1, 0x7f080022

    invoke-virtual {p1, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Llo;->d:Landroid/graphics/Typeface;

    .line 36
    :cond_3
    sget-object v0, Llo;->e:Landroid/graphics/Typeface;

    if-nez v0, :cond_4

    .line 37
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const v1, 0x7f080023

    invoke-virtual {p1, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Llo;->e:Landroid/graphics/Typeface;

    .line 39
    :cond_4
    return-void
.end method
