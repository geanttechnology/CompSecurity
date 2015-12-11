.class public Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;
.super Ljava/lang/Object;
.source "BaseImageDownloader.java"

# interfaces
.implements Lcom/nostra13/universalimageloader/core/download/ImageDownloader;


# static fields
.field private static synthetic $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme:[I = null

.field protected static final ALLOWED_URI_CHARS:Ljava/lang/String; = "@#&=*+-_.,:!?()/~\'%"

.field protected static final BUFFER_SIZE:I = 0x2000

.field public static final DEFAULT_HTTP_CONNECT_TIMEOUT:I = 0x1388

.field public static final DEFAULT_HTTP_READ_TIMEOUT:I = 0x4e20

.field private static final ERROR_UNSUPPORTED_SCHEME:Ljava/lang/String; = "UIL doesn\'t support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))"

.field private static final MAX_REDIRECT_COUNT:I = 0x5


# instance fields
.field protected final connectTimeout:I

.field protected final context:Landroid/content/Context;

.field protected final readTimeout:I


# direct methods
.method static synthetic $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()[I
    .locals 3

    .prologue
    .line 47
    sget-object v0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->$SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->values()[Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ASSETS:Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_6

    :goto_1
    :try_start_1
    sget-object v1, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->CONTENT:Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_5

    :goto_2
    :try_start_2
    sget-object v1, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->DRAWABLE:Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_4

    :goto_3
    :try_start_3
    sget-object v1, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->FILE:Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_3

    :goto_4
    :try_start_4
    sget-object v1, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->HTTP:Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_2

    :goto_5
    :try_start_5
    sget-object v1, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->HTTPS:Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_1

    :goto_6
    :try_start_6
    sget-object v1, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->UNKNOWN:Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_0

    :goto_7
    sput-object v0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->$SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_7

    :catch_1
    move-exception v1

    goto :goto_6

    :catch_2
    move-exception v1

    goto :goto_5

    :catch_3
    move-exception v1

    goto :goto_4

    :catch_4
    move-exception v1

    goto :goto_3

    :catch_5
    move-exception v1

    goto :goto_2

    :catch_6
    move-exception v1

    goto :goto_1
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->context:Landroid/content/Context;

    .line 69
    const/16 v0, 0x1388

    iput v0, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->connectTimeout:I

    .line 70
    const/16 v0, 0x4e20

    iput v0, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->readTimeout:I

    .line 71
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;II)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "connectTimeout"    # I
    .param p3, "readTimeout"    # I

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->context:Landroid/content/Context;

    .line 75
    iput p2, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->connectTimeout:I

    .line 76
    iput p3, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->readTimeout:I

    .line 77
    return-void
.end method

.method private connectTo(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 122
    const-string v2, "@#&=*+-_.,:!?()/~\'%"

    invoke-static {p1, v2}, Landroid/net/Uri;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 123
    .local v1, "encodedUrl":Ljava/lang/String;
    new-instance v2, Ljava/net/URL;

    invoke-direct {v2, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 124
    .local v0, "conn":Ljava/net/HttpURLConnection;
    iget v2, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->connectTimeout:I

    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 125
    iget v2, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->readTimeout:I

    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 126
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->connect()V

    .line 127
    return-object v0
.end method


# virtual methods
.method public getStream(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;
    .locals 2
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "extra"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 81
    invoke-static {}, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->$SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()[I

    move-result-object v0

    invoke-static {p1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ofUri(Ljava/lang/String;)Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    move-result-object v1

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 95
    invoke-virtual {p0, p1, p2}, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->getStreamFromOtherSource(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;

    move-result-object v0

    :goto_0
    return-object v0

    .line 84
    :pswitch_0
    invoke-virtual {p0, p1, p2}, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->getStreamFromNetwork(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0

    .line 86
    :pswitch_1
    invoke-virtual {p0, p1, p2}, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->getStreamFromFile(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0

    .line 88
    :pswitch_2
    invoke-virtual {p0, p1, p2}, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->getStreamFromContent(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0

    .line 90
    :pswitch_3
    invoke-virtual {p0, p1, p2}, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->getStreamFromAssets(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0

    .line 92
    :pswitch_4
    invoke-virtual {p0, p1, p2}, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->getStreamFromDrawable(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0

    .line 81
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method protected getStreamFromAssets(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;
    .locals 2
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "extra"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 169
    sget-object v1, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->ASSETS:Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    invoke-virtual {v1, p1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->crop(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 170
    .local v0, "filePath":Ljava/lang/String;
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    return-object v1
.end method

.method protected getStreamFromContent(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;
    .locals 3
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "extra"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .line 154
    iget-object v2, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 155
    .local v0, "res":Landroid/content/ContentResolver;
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 156
    .local v1, "uri":Landroid/net/Uri;
    invoke-virtual {v0, v1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v2

    return-object v2
.end method

.method protected getStreamFromDrawable(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;
    .locals 7
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "extra"    # Ljava/lang/Object;

    .prologue
    .line 182
    sget-object v5, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->DRAWABLE:Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    invoke-virtual {v5, p1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->crop(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 183
    .local v3, "drawableIdString":Ljava/lang/String;
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .line 184
    .local v2, "drawableId":I
    iget-object v5, p0, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->context:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    .line 185
    .local v1, "drawable":Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 187
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    new-instance v4, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v4}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 188
    .local v4, "os":Ljava/io/ByteArrayOutputStream;
    sget-object v5, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/4 v6, 0x0

    invoke-virtual {v0, v5, v6, v4}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 189
    new-instance v5, Ljava/io/ByteArrayInputStream;

    invoke-virtual {v4}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    return-object v5
.end method

.method protected getStreamFromFile(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;
    .locals 4
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "extra"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 140
    sget-object v1, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->FILE:Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;

    invoke-virtual {v1, p1}, Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;->crop(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 141
    .local v0, "filePath":Ljava/lang/String;
    new-instance v1, Ljava/io/BufferedInputStream;

    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v0}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    const/16 v3, 0x2000

    invoke-direct {v1, v2, v3}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    return-object v1
.end method

.method protected getStreamFromNetwork(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;
    .locals 5
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "extra"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 110
    invoke-direct {p0, p1}, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->connectTo(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v0

    .line 112
    .local v0, "conn":Ljava/net/HttpURLConnection;
    const/4 v1, 0x0

    .line 113
    .local v1, "redirectCount":I
    :goto_0
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    div-int/lit8 v2, v2, 0x64

    const/4 v3, 0x3

    if-ne v2, v3, :cond_0

    const/4 v2, 0x5

    if-lt v1, v2, :cond_1

    .line 118
    :cond_0
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    const/16 v4, 0x2000

    invoke-direct {v2, v3, v4}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    return-object v2

    .line 114
    :cond_1
    const-string v2, "Location"

    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/nostra13/universalimageloader/core/download/BaseImageDownloader;->connectTo(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v0

    .line 115
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method protected getStreamFromOtherSource(Ljava/lang/String;Ljava/lang/Object;)Ljava/io/InputStream;
    .locals 4
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "extra"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 206
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "UIL doesn\'t support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
