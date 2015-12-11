.class Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$3;
.super Ljava/lang/Object;
.source "ListingDetailsMenuPopup.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->updateDrawer(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$3;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 146
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$3;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    iget-object v1, v2, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    check-cast v1, Lcom/poshmark/ui/PMContainerActivity;

    .line 147
    .local v1, "parent":Lcom/poshmark/ui/PMContainerActivity;
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$3;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->dismiss()V

    .line 148
    new-instance v0, Lcom/poshmark/utils/ReportListingDialog;

    new-instance v2, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$3$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$3$1;-><init>(Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$3;)V

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/ReportListingDialog;-><init>(Landroid/app/Activity;Lcom/poshmark/utils/ReportListingDialog$ReportReasonListener;)V

    .line 157
    .local v0, "alert":Lcom/poshmark/utils/ReportListingDialog;
    invoke-virtual {v0}, Lcom/poshmark/utils/ReportListingDialog;->show()V

    .line 158
    return-void
.end method
