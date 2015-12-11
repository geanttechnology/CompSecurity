.class Lcom/poshmark/ui/fragments/ShareFragment$7;
.super Ljava/lang/Object;
.source "ShareFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShareFragment;->setupButtonHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShareFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0

    .prologue
    .line 286
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShareFragment$7;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 290
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$7;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    # invokes: Lcom/poshmark/ui/fragments/ShareFragment;->doSMSShare()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ShareFragment;->access$500(Lcom/poshmark/ui/fragments/ShareFragment;)V

    .line 291
    return-void
.end method
