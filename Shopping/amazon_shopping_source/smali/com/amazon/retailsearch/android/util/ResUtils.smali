.class public Lcom/amazon/retailsearch/android/util/ResUtils;
.super Ljava/lang/Object;
.source "ResUtils.java"


# static fields
.field private static final ATTR_NAMESPACE:Ljava/lang/String; = "http://schemas.android.com/apk/res-auto"

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/retailsearch/android/util/ResUtils;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/util/ResUtils;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method

.method public static getAttributeBooleanValue(Landroid/util/AttributeSet;Ljava/lang/String;Z)Z
    .locals 1
    .param p0, "attrs"    # Landroid/util/AttributeSet;
    .param p1, "attrName"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Z

    .prologue
    .line 71
    if-nez p0, :cond_0

    .line 75
    .end local p2    # "defaultValue":Z
    :goto_0
    return p2

    .restart local p2    # "defaultValue":Z
    :cond_0
    const-string/jumbo v0, "http://schemas.android.com/apk/res-auto"

    invoke-interface {p0, v0, p1, p2}, Landroid/util/AttributeSet;->getAttributeBooleanValue(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result p2

    goto :goto_0
.end method

.method public static getAttributeIntValue(Landroid/util/AttributeSet;Ljava/lang/String;I)I
    .locals 1
    .param p0, "attrs"    # Landroid/util/AttributeSet;
    .param p1, "attrName"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 90
    if-nez p0, :cond_0

    .line 94
    .end local p2    # "defaultValue":I
    :goto_0
    return p2

    .restart local p2    # "defaultValue":I
    :cond_0
    const-string/jumbo v0, "http://schemas.android.com/apk/res-auto"

    invoke-interface {p0, v0, p1, p2}, Landroid/util/AttributeSet;->getAttributeIntValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result p2

    goto :goto_0
.end method

.method public static getResourceId(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I
    .locals 3
    .param p0, "defaultId"    # I
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "name"    # Ljava/lang/String;

    .prologue
    .line 46
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, p3, p2, v2}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 47
    .local v0, "resId":I
    if-nez v0, :cond_0

    .line 53
    .end local p0    # "defaultId":I
    :goto_0
    return p0

    .restart local p0    # "defaultId":I
    :cond_0
    move p0, v0

    goto :goto_0
.end method

.method public static loadFontFromRes(ILandroid/content/Context;)Landroid/graphics/Typeface;
    .locals 10
    .param p0, "resource"    # I
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 105
    const/4 v6, 0x0

    .line 106
    .local v6, "tf":Landroid/graphics/Typeface;
    const/4 v3, 0x0

    .line 109
    .local v3, "is":Ljava/io/InputStream;
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-virtual {v7, p0}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;
    :try_end_0
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v3

    .line 120
    :try_start_1
    invoke-virtual {v3}, Ljava/io/InputStream;->available()I

    move-result v7

    new-array v1, v7, [B

    .line 121
    .local v1, "buffer":[B
    const/4 v4, 0x0

    .line 122
    .local v4, "l":I
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, "/rs_font"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, ".raw"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 123
    .local v5, "outPath":Ljava/lang/String;
    new-instance v0, Ljava/io/BufferedOutputStream;

    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-direct {v0, v7}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 124
    .local v0, "bos":Ljava/io/BufferedOutputStream;
    :goto_0
    invoke-virtual {v3, v1}, Ljava/io/InputStream;->read([B)I

    move-result v4

    if-lez v4, :cond_0

    .line 126
    const/4 v7, 0x0

    invoke-virtual {v0, v1, v7, v4}, Ljava/io/BufferedOutputStream;->write([BII)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 132
    .end local v0    # "bos":Ljava/io/BufferedOutputStream;
    .end local v1    # "buffer":[B
    .end local v4    # "l":I
    .end local v5    # "outPath":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 134
    .local v2, "e":Ljava/io/IOException;
    sget-object v7, Lcom/amazon/retailsearch/android/util/ResUtils;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v8, "Could not openRawResource font"

    invoke-interface {v7, v8, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .end local v2    # "e":Ljava/io/IOException;
    :goto_1
    move-object v7, v6

    .line 137
    :goto_2
    return-object v7

    .line 111
    :catch_1
    move-exception v2

    .line 113
    .local v2, "e":Landroid/content/res/Resources$NotFoundException;
    sget-object v7, Lcom/amazon/retailsearch/android/util/ResUtils;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v8, "Could not openRawResource font"

    invoke-interface {v7, v8, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 114
    const/4 v7, 0x0

    goto :goto_2

    .line 128
    .end local v2    # "e":Landroid/content/res/Resources$NotFoundException;
    .restart local v0    # "bos":Ljava/io/BufferedOutputStream;
    .restart local v1    # "buffer":[B
    .restart local v4    # "l":I
    .restart local v5    # "outPath":Ljava/lang/String;
    :cond_0
    :try_start_2
    invoke-virtual {v0}, Ljava/io/BufferedOutputStream;->close()V

    .line 129
    invoke-static {v5}, Landroid/graphics/Typeface;->createFromFile(Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v6

    .line 130
    new-instance v7, Ljava/io/File;

    invoke-direct {v7, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/io/File;->delete()Z
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1
.end method
