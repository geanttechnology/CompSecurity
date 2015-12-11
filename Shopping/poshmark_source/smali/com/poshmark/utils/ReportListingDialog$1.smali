.class Lcom/poshmark/utils/ReportListingDialog$1;
.super Ljava/lang/Object;
.source "ReportListingDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/ReportListingDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/ReportListingDialog;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ReportListingDialog;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/poshmark/utils/ReportListingDialog$1;->this$0:Lcom/poshmark/utils/ReportListingDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 68
    iget-object v0, p0, Lcom/poshmark/utils/ReportListingDialog$1;->this$0:Lcom/poshmark/utils/ReportListingDialog;

    iget-object v1, v0, Lcom/poshmark/utils/ReportListingDialog;->listener:Lcom/poshmark/utils/ReportListingDialog$ReportReasonListener;

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {v1, v0}, Lcom/poshmark/utils/ReportListingDialog$ReportReasonListener;->reasonPicked(Ljava/lang/String;)V

    .line 69
    iget-object v0, p0, Lcom/poshmark/utils/ReportListingDialog$1;->this$0:Lcom/poshmark/utils/ReportListingDialog;

    iget-object v0, v0, Lcom/poshmark/utils/ReportListingDialog;->dialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->hide()V

    .line 70
    return-void
.end method
