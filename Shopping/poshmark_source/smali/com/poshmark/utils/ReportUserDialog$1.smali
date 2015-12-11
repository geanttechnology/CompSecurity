.class Lcom/poshmark/utils/ReportUserDialog$1;
.super Ljava/lang/Object;
.source "ReportUserDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/ReportUserDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/ReportUserDialog;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ReportUserDialog;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/poshmark/utils/ReportUserDialog$1;->this$0:Lcom/poshmark/utils/ReportUserDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/poshmark/utils/ReportUserDialog$1;->this$0:Lcom/poshmark/utils/ReportUserDialog;

    iget-object v1, v0, Lcom/poshmark/utils/ReportUserDialog;->listener:Lcom/poshmark/utils/ReportUserDialog$ReportReasonListener;

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {v1, v0}, Lcom/poshmark/utils/ReportUserDialog$ReportReasonListener;->reasonPicked(Ljava/lang/String;)V

    .line 67
    iget-object v0, p0, Lcom/poshmark/utils/ReportUserDialog$1;->this$0:Lcom/poshmark/utils/ReportUserDialog;

    iget-object v0, v0, Lcom/poshmark/utils/ReportUserDialog;->dialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->hide()V

    .line 68
    return-void
.end method
