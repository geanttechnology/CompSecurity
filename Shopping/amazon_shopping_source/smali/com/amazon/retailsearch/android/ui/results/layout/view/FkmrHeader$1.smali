.class Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader$1;
.super Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;
.source "FkmrHeader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->build(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;

.field final synthetic val$fkmr:Lcom/amazon/searchapp/retailsearch/model/FKMR;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;Landroid/content/res/Resources;Lcom/amazon/searchapp/retailsearch/model/FKMR;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/res/Resources;

    .prologue
    .line 94
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;

    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader$1;->val$fkmr:Lcom/amazon/searchapp/retailsearch/model/FKMR;

    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;-><init>(Landroid/content/res/Resources;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader$1;->val$fkmr:Lcom/amazon/searchapp/retailsearch/model/FKMR;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getSeeAllLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->search(Ljava/lang/String;)V

    .line 99
    return-void
.end method
