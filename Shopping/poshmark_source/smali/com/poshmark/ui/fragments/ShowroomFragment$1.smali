.class Lcom/poshmark/ui/fragments/ShowroomFragment$1;
.super Ljava/lang/Object;
.source "ShowroomFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShowroomFragment;->setupActionBarShareActionButton()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 241
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    # invokes: Lcom/poshmark/ui/fragments/ShowroomFragment;->shareShowroom()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->access$000(Lcom/poshmark/ui/fragments/ShowroomFragment;)V

    .line 242
    return-void
.end method
