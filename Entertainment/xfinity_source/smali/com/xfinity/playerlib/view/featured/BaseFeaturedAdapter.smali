.class public abstract Lcom/xfinity/playerlib/view/featured/BaseFeaturedAdapter;
.super Landroid/widget/BaseAdapter;
.source "BaseFeaturedAdapter.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field programs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<+",
            "Lcom/xfinity/playerlib/model/EditorialProgram;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/xfinity/playerlib/view/featured/CoverAdapter;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/featured/BaseFeaturedAdapter;->LOG:Lorg/slf4j/Logger;

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/BaseFeaturedAdapter;->programs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public abstract getGalleryLayoutParams()Landroid/widget/Gallery$LayoutParams;
.end method
