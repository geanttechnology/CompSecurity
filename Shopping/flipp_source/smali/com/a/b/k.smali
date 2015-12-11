.class final Lcom/a/b/k;
.super Lcom/a/b/d;
.source "SourceFile"


# static fields
.field private static final p:Landroid/content/UriMatcher;


# instance fields
.field final o:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 51
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    .line 52
    sput-object v0, Lcom/a/b/k;->p:Landroid/content/UriMatcher;

    const-string v1, "com.android.contacts"

    const-string v2, "contacts/lookup/*/#"

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 53
    sget-object v0, Lcom/a/b/k;->p:Landroid/content/UriMatcher;

    const-string v1, "com.android.contacts"

    const-string v2, "contacts/lookup/*"

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 54
    sget-object v0, Lcom/a/b/k;->p:Landroid/content/UriMatcher;

    const-string v1, "com.android.contacts"

    const-string v2, "contacts/#/photo"

    const/4 v3, 0x2

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 55
    sget-object v0, Lcom/a/b/k;->p:Landroid/content/UriMatcher;

    const-string v1, "com.android.contacts"

    const-string v2, "contacts/#"

    const/4 v3, 0x3

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 56
    sget-object v0, Lcom/a/b/k;->p:Landroid/content/UriMatcher;

    const-string v1, "com.android.contacts"

    const-string v2, "display_photo/#"

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 57
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V
    .locals 6

    .prologue
    .line 63
    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-direct/range {v0 .. v5}, Lcom/a/b/d;-><init>(Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    .line 64
    iput-object p1, p0, Lcom/a/b/k;->o:Landroid/content/Context;

    .line 65
    return-void
.end method

.method private a(Ljava/io/InputStream;Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 106
    if-nez p1, :cond_0

    .line 121
    :goto_0
    return-object v1

    .line 110
    :cond_0
    invoke-virtual {p2}, Lcom/a/b/ao;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 111
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 112
    const/4 v2, 0x1

    iput-boolean v2, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 113
    invoke-direct {p0}, Lcom/a/b/k;->c()Ljava/io/InputStream;

    move-result-object v2

    .line 115
    const/4 v3, 0x0

    :try_start_0
    invoke-static {v2, v3, v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 117
    invoke-static {v2}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    .line 119
    iget v2, p2, Lcom/a/b/ao;->d:I

    iget v3, p2, Lcom/a/b/ao;->e:I

    invoke-static {v2, v3, v0}, Lcom/a/b/k;->a(IILandroid/graphics/BitmapFactory$Options;)V

    .line 121
    :goto_1
    invoke-static {p1, v1, v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    goto :goto_0

    .line 117
    :catchall_0
    move-exception v0

    invoke-static {v2}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    throw v0

    :cond_1
    move-object v0, v1

    goto :goto_1
.end method

.method private c()Ljava/io/InputStream;
    .locals 4

    .prologue
    .line 82
    iget-object v0, p0, Lcom/a/b/k;->o:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 83
    iget-object v0, p0, Lcom/a/b/d;->g:Lcom/a/b/ao;

    iget-object v0, v0, Lcom/a/b/ao;->a:Landroid/net/Uri;

    .line 84
    sget-object v2, Lcom/a/b/k;->p:Landroid/content/UriMatcher;

    invoke-virtual {v2, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 101
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Invalid uri: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 86
    :pswitch_0
    invoke-static {v1, v0}, Landroid/provider/ContactsContract$Contacts;->lookupContact(Landroid/content/ContentResolver;Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v0

    .line 87
    if-nez v0, :cond_0

    .line 88
    const/4 v0, 0x0

    .line 99
    :goto_0
    return-object v0

    .line 92
    :cond_0
    :pswitch_1
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xe

    if-ge v2, v3, :cond_1

    .line 93
    invoke-static {v1, v0}, Landroid/provider/ContactsContract$Contacts;->openContactPhotoInputStream(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0

    .line 95
    :cond_1
    const/4 v2, 0x1

    invoke-static {v1, v0, v2}, Landroid/provider/ContactsContract$Contacts;->openContactPhotoInputStream(Landroid/content/ContentResolver;Landroid/net/Uri;Z)Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0

    .line 99
    :pswitch_2
    invoke-virtual {v1, v0}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0

    .line 84
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method final a(Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    .locals 2

    .prologue
    .line 68
    const/4 v1, 0x0

    .line 70
    :try_start_0
    invoke-direct {p0}, Lcom/a/b/k;->c()Ljava/io/InputStream;

    move-result-object v1

    .line 71
    invoke-direct {p0, v1, p1}, Lcom/a/b/k;->a(Ljava/io/InputStream;Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 73
    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    return-object v0

    :catchall_0
    move-exception v0

    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    throw v0
.end method

.method final a()Lcom/a/b/aj;
    .locals 1

    .prologue
    .line 78
    sget-object v0, Lcom/a/b/aj;->b:Lcom/a/b/aj;

    return-object v0
.end method
