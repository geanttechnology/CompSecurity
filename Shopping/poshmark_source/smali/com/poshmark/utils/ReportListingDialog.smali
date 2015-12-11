.class public Lcom/poshmark/utils/ReportListingDialog;
.super Ljava/lang/Object;
.source "ReportListingDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/ReportListingDialog$ReportReasonListener;
    }
.end annotation


# static fields
.field static reportUserOrListingListener:Landroid/view/View$OnClickListener;


# instance fields
.field alertView:Landroid/view/View;

.field dialog:Landroid/app/AlertDialog;

.field layoutId:I

.field listener:Lcom/poshmark/utils/ReportListingDialog$ReportReasonListener;

.field parent:Landroid/app/Activity;

.field reasonButtonListener:Landroid/view/View$OnClickListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 77
    new-instance v0, Lcom/poshmark/utils/ReportListingDialog$2;

    invoke-direct {v0}, Lcom/poshmark/utils/ReportListingDialog$2;-><init>()V

    sput-object v0, Lcom/poshmark/utils/ReportListingDialog;->reportUserOrListingListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/poshmark/utils/ReportListingDialog$ReportReasonListener;)V
    .locals 3
    .param p1, "parentActivity"    # Landroid/app/Activity;
    .param p2, "listener"    # Lcom/poshmark/utils/ReportListingDialog$ReportReasonListener;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    new-instance v0, Lcom/poshmark/utils/ReportListingDialog$1;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/ReportListingDialog$1;-><init>(Lcom/poshmark/utils/ReportListingDialog;)V

    iput-object v0, p0, Lcom/poshmark/utils/ReportListingDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    .line 21
    iget v0, p0, Lcom/poshmark/utils/ReportListingDialog;->layoutId:I

    iput v0, p0, Lcom/poshmark/utils/ReportListingDialog;->layoutId:I

    .line 22
    iput-object p1, p0, Lcom/poshmark/utils/ReportListingDialog;->parent:Landroid/app/Activity;

    .line 23
    iput-object p2, p0, Lcom/poshmark/utils/ReportListingDialog;->listener:Lcom/poshmark/utils/ReportListingDialog$ReportReasonListener;

    .line 25
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0300a8

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/ReportListingDialog;->alertView:Landroid/view/View;

    .line 26
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->alertView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const-string v1, "Report Listing"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/ReportListingDialog;->dialog:Landroid/app/AlertDialog;

    .line 31
    invoke-direct {p0}, Lcom/poshmark/utils/ReportListingDialog;->setupButtonHandlers()V

    .line 33
    return-void
.end method

.method private setupButtonHandlers()V
    .locals 3

    .prologue
    .line 36
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0274

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 37
    .local v0, "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    const-string v1, "replica"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 40
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0275

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 41
    .restart local v0    # "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 42
    const-string v1, "offline_transaction"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 44
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0276

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 45
    .restart local v0    # "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 46
    const-string v1, "not_allowed"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 48
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0279

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 49
    .restart local v0    # "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 50
    const-string v1, "offensive"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 52
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0277

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 53
    .restart local v0    # "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 54
    const-string v1, "spam"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 56
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0278

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 57
    .restart local v0    # "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportListingDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 58
    const-string v1, "harassment"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 60
    return-void
.end method


# virtual methods
.method public show()V
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/poshmark/utils/ReportListingDialog;->dialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 63
    return-void
.end method
