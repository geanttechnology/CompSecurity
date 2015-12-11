.class Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$6;
.super Ljava/lang/Object;
.source "EmbeddedBrowserContainer.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->initializeButtons()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)V
    .locals 0

    .prologue
    .line 188
    iput-object p1, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$6;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 190
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$6;->this$0:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    # getter for: Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mActivity:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;
    invoke-static {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->access$300(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->openOptionsMenu()V

    .line 191
    return-void
.end method
