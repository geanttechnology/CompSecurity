.class public Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;
.super Ljava/lang/Object;
.source "ImageWrapperModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$1;,
        Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;
    }
.end annotation


# instance fields
.field private final asin:Ljava/lang/String;

.field private final contentDescription:Ljava/lang/String;

.field private final image:Lcom/amazon/ansel/fetch/ImageRequest;

.field private final imageList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/ImageRequest;",
            ">;"
        }
    .end annotation
.end field

.field private final resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->asin:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->asin:Ljava/lang/String;

    .line 42
    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->contentDescription:Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->contentDescription:Ljava/lang/String;

    .line 43
    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->image:Lcom/amazon/ansel/fetch/ImageRequest;
    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->access$200(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)Lcom/amazon/ansel/fetch/ImageRequest;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->image:Lcom/amazon/ansel/fetch/ImageRequest;

    .line 44
    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->imageList:Ljava/util/List;
    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->access$300(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->imageList:Ljava/util/List;

    .line 45
    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;
    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;->access$400(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)Lcom/amazon/ansel/fetch/ResourceProvider;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 46
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$1;

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel$Builder;)V

    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getContentDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->contentDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getImage()Lcom/amazon/ansel/fetch/ImageRequest;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->image:Lcom/amazon/ansel/fetch/ImageRequest;

    return-object v0
.end method

.method public getImageList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/ImageRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->imageList:Ljava/util/List;

    return-object v0
.end method

.method public getResourceProvider()Lcom/amazon/ansel/fetch/ResourceProvider;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    return-object v0
.end method
