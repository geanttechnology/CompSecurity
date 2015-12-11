.class Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;
.super Lcom/amazon/ansel/fetch/AbstractResourceListener;
.source "SRDSAssetsLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->retreiveBadges(Lcom/amazon/searchapp/retailsearch/model/Assets;)Ljava/util/Map;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/ansel/fetch/AbstractResourceListener",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

.field final synthetic val$badgeId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 247
    iput-object p1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    iput-object p2, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;->val$badgeId:Ljava/lang/String;

    invoke-direct {p0}, Lcom/amazon/ansel/fetch/AbstractResourceListener;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 250
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->doLoad:Z
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$202(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Z)Z

    .line 251
    return-void
.end method

.method public result(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "result"    # Landroid/graphics/Bitmap;

    .prologue
    .line 255
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    # getter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->badges:Ljava/util/Map;
    invoke-static {v0}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$300(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Ljava/util/Map;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;->val$badgeId:Ljava/lang/String;

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 256
    return-void
.end method

.method public bridge synthetic result(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 247
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;->result(Landroid/graphics/Bitmap;)V

    return-void
.end method
