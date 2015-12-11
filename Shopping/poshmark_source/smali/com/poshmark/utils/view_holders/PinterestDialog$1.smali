.class Lcom/poshmark/utils/view_holders/PinterestDialog$1;
.super Ljava/lang/Object;
.source "PinterestDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/view_holders/PinterestDialog;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/view_holders/PinterestDialog;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/view_holders/PinterestDialog;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/poshmark/utils/view_holders/PinterestDialog$1;->this$0:Lcom/poshmark/utils/view_holders/PinterestDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/poshmark/utils/view_holders/PinterestDialog$1;->this$0:Lcom/poshmark/utils/view_holders/PinterestDialog;

    invoke-virtual {v0}, Lcom/poshmark/utils/view_holders/PinterestDialog;->dismiss()V

    .line 37
    return-void
.end method
