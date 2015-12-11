.class public Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;
.super Ljava/lang/Object;
.source "ImageWrapperModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private asin:Ljava/lang/String;

.field private contentDescription:Ljava/lang/String;

.field private image:Lcom/amazon/ansel/fetch/ImageRequest;

.field private imageList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/ImageRequest;",
            ">;"
        }
    .end annotation
.end field

.field private resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->asin:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->contentDescription:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)Lcom/amazon/ansel/fetch/ImageRequest;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->image:Lcom/amazon/ansel/fetch/ImageRequest;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->imageList:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)Lcom/amazon/ansel/fetch/ResourceProvider;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    return-object v0
.end method

.method private createImageList(Lcom/amazon/searchapp/retailsearch/model/Image;Ljava/util/List;Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;)Ljava/util/List;
    .locals 5
    .param p1, "primaryImage"    # Lcom/amazon/searchapp/retailsearch/model/Image;
    .param p3, "productImageFactory"    # Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;",
            "Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/ImageRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 137
    .local p2, "altImages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Image;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->getImageUrls(Lcom/amazon/searchapp/retailsearch/model/Image;Ljava/util/List;Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;)Ljava/util/HashSet;

    move-result-object v3

    .line 138
    .local v3, "urls":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/HashSet;->size()I

    move-result v4

    invoke-direct {v1, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 140
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/ImageRequest;>;"
    invoke-virtual {v3}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 142
    .local v2, "url":Ljava/lang/String;
    invoke-interface {p3, v2}, Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;->fromUrl(Ljava/lang/String;)Lcom/amazon/ansel/fetch/ImageRequest;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 145
    .end local v2    # "url":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method private getImageUrls(Lcom/amazon/searchapp/retailsearch/model/Image;Ljava/util/List;Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;)Ljava/util/HashSet;
    .locals 4
    .param p1, "primaryImage"    # Lcom/amazon/searchapp/retailsearch/model/Image;
    .param p3, "productImageFactory"    # Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;",
            "Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;",
            ")",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 151
    .local p2, "altImages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Image;>;"
    new-instance v2, Ljava/util/LinkedHashSet;

    const/4 v3, 0x5

    invoke-direct {v2, v3}, Ljava/util/LinkedHashSet;-><init>(I)V

    .line 153
    .local v2, "urls":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 155
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 158
    :cond_0
    if-eqz p2, :cond_2

    .line 160
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/Image;

    .line 162
    .local v0, "altImage":Lcom/amazon/searchapp/retailsearch/model/Image;
    if-eqz v0, :cond_1

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 167
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 171
    .end local v0    # "altImage":Lcom/amazon/searchapp/retailsearch/model/Image;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_2
    return-object v2
.end method


# virtual methods
.method public build(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/model/Image;Ljava/util/List;ZLcom/amazon/retailsearch/android/ui/ImageRequestFactory;Lcom/amazon/ansel/fetch/ResourceProvider;)Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "primaryImage"    # Lcom/amazon/searchapp/retailsearch/model/Image;
    .param p5, "buildImageList"    # Z
    .param p6, "productImageFactory"    # Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;
    .param p7, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;Z",
            "Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;",
            "Lcom/amazon/ansel/fetch/ResourceProvider;",
            ")",
            "Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;"
        }
    .end annotation

    .prologue
    .local p4, "altImages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Image;>;"
    const/4 v0, 0x0

    .line 105
    if-eqz p1, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 131
    .end local p2    # "title":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v0

    .line 109
    .restart local p2    # "title":Ljava/lang/String;
    :cond_1
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->asin:Ljava/lang/String;

    .line 111
    if-eqz p2, :cond_4

    .end local p2    # "title":Ljava/lang/String;
    :goto_1
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->contentDescription:Ljava/lang/String;

    .line 113
    if-eqz p3, :cond_2

    invoke-interface {p3}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 114
    invoke-interface {p3}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p6, v1}, Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;->fromUrl(Ljava/lang/String;)Lcom/amazon/ansel/fetch/ImageRequest;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->image:Lcom/amazon/ansel/fetch/ImageRequest;

    .line 117
    :cond_2
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->image:Lcom/amazon/ansel/fetch/ImageRequest;

    if-eqz v1, :cond_0

    .line 121
    if-eqz p5, :cond_3

    .line 122
    invoke-direct {p0, p3, p4, p6}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->createImageList(Lcom/amazon/searchapp/retailsearch/model/Image;Ljava/util/List;Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->imageList:Ljava/util/List;

    .line 124
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->imageList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 129
    :cond_3
    iput-object p7, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 131
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;

    invoke-direct {v1, p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$1;)V

    move-object v0, v1

    goto :goto_0

    .line 111
    .restart local p2    # "title":Ljava/lang/String;
    :cond_4
    const-string/jumbo p2, ""

    goto :goto_1
.end method
