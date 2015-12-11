.class Lcom/facebook/widget/ImageRequest;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final HEIGHT_PARAM:Ljava/lang/String; = "height"

.field private static final MIGRATION_PARAM:Ljava/lang/String; = "migration_overrides"

.field private static final MIGRATION_VALUE:Ljava/lang/String; = "{october_2012:true}"

.field private static final PROFILEPIC_URL_FORMAT:Ljava/lang/String; = "https://graph.facebook.com/%s/picture"

.field static final UNSPECIFIED_DIMENSION:I = 0x0

.field private static final WIDTH_PARAM:Ljava/lang/String; = "width"


# instance fields
.field private allowCachedRedirects:Z

.field private callback:Lcom/facebook/widget/ImageRequest$Callback;

.field private callerTag:Ljava/lang/Object;

.field private context:Landroid/content/Context;

.field private imageUrl:Ljava/net/URL;


# direct methods
.method private constructor <init>(Lcom/facebook/widget/ImageRequest$Builder;)V
    .locals 1

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    # getter for: Lcom/facebook/widget/ImageRequest$Builder;->context:Landroid/content/Context;
    invoke-static {p1}, Lcom/facebook/widget/ImageRequest$Builder;->access$000(Lcom/facebook/widget/ImageRequest$Builder;)Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/widget/ImageRequest;->context:Landroid/content/Context;

    .line 84
    # getter for: Lcom/facebook/widget/ImageRequest$Builder;->imageUrl:Ljava/net/URL;
    invoke-static {p1}, Lcom/facebook/widget/ImageRequest$Builder;->access$100(Lcom/facebook/widget/ImageRequest$Builder;)Ljava/net/URL;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/widget/ImageRequest;->imageUrl:Ljava/net/URL;

    .line 85
    # getter for: Lcom/facebook/widget/ImageRequest$Builder;->callback:Lcom/facebook/widget/ImageRequest$Callback;
    invoke-static {p1}, Lcom/facebook/widget/ImageRequest$Builder;->access$200(Lcom/facebook/widget/ImageRequest$Builder;)Lcom/facebook/widget/ImageRequest$Callback;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/widget/ImageRequest;->callback:Lcom/facebook/widget/ImageRequest$Callback;

    .line 86
    # getter for: Lcom/facebook/widget/ImageRequest$Builder;->allowCachedRedirects:Z
    invoke-static {p1}, Lcom/facebook/widget/ImageRequest$Builder;->access$300(Lcom/facebook/widget/ImageRequest$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/facebook/widget/ImageRequest;->allowCachedRedirects:Z

    .line 87
    # getter for: Lcom/facebook/widget/ImageRequest$Builder;->callerTag:Ljava/lang/Object;
    invoke-static {p1}, Lcom/facebook/widget/ImageRequest$Builder;->access$400(Lcom/facebook/widget/ImageRequest$Builder;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    :goto_0
    iput-object v0, p0, Lcom/facebook/widget/ImageRequest;->callerTag:Ljava/lang/Object;

    .line 88
    return-void

    .line 87
    :cond_0
    # getter for: Lcom/facebook/widget/ImageRequest$Builder;->callerTag:Ljava/lang/Object;
    invoke-static {p1}, Lcom/facebook/widget/ImageRequest$Builder;->access$400(Lcom/facebook/widget/ImageRequest$Builder;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method synthetic constructor <init>(Lcom/facebook/widget/ImageRequest$Builder;Lcom/facebook/widget/ImageRequest$1;)V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lcom/facebook/widget/ImageRequest;-><init>(Lcom/facebook/widget/ImageRequest$Builder;)V

    return-void
.end method

.method static getProfilePictureUrl(Ljava/lang/String;II)Ljava/net/URL;
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 58
    const-string v0, "userId"

    invoke-static {p0, v0}, Lcom/facebook/internal/Validate;->notNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    invoke-static {p1, v5}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 61
    invoke-static {p2, v5}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 63
    if-nez v0, :cond_0

    if-nez v1, :cond_0

    .line 64
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Either width or height must be greater than 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 67
    :cond_0
    new-instance v2, Landroid/net/Uri$Builder;

    invoke-direct {v2}, Landroid/net/Uri$Builder;-><init>()V

    const-string v3, "https://graph.facebook.com/%s/picture"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p0, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/net/Uri$Builder;->encodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v2

    .line 69
    if-eqz v1, :cond_1

    .line 70
    const-string v3, "height"

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v3, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 73
    :cond_1
    if-eqz v0, :cond_2

    .line 74
    const-string v1, "width"

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v1, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 77
    :cond_2
    const-string v0, "migration_overrides"

    const-string v1, "{october_2012:true}"

    invoke-virtual {v2, v0, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 79
    new-instance v0, Ljava/net/URL;

    invoke-virtual {v2}, Landroid/net/Uri$Builder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method getCallback()Lcom/facebook/widget/ImageRequest$Callback;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/facebook/widget/ImageRequest;->callback:Lcom/facebook/widget/ImageRequest$Callback;

    return-object v0
.end method

.method getCallerTag()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/facebook/widget/ImageRequest;->callerTag:Ljava/lang/Object;

    return-object v0
.end method

.method getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/facebook/widget/ImageRequest;->context:Landroid/content/Context;

    return-object v0
.end method

.method getImageUrl()Ljava/net/URL;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/facebook/widget/ImageRequest;->imageUrl:Ljava/net/URL;

    return-object v0
.end method

.method isCachedRedirectAllowed()Z
    .locals 1

    .prologue
    .line 103
    iget-boolean v0, p0, Lcom/facebook/widget/ImageRequest;->allowCachedRedirects:Z

    return v0
.end method
