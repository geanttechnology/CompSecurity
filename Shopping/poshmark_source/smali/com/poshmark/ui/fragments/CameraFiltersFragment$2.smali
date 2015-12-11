.class Lcom/poshmark/ui/fragments/CameraFiltersFragment$2;
.super Ljava/lang/Object;
.source "CameraFiltersFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CameraFiltersFragment;->setupFilterButtonHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$2;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 141
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$2;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraFiltersFragment;->resetImage()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->access$100(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V

    .line 142
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$2;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->currentFilter:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 143
    return-void
.end method
