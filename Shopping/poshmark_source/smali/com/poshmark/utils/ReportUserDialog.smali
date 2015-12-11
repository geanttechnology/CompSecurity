.class public Lcom/poshmark/utils/ReportUserDialog;
.super Ljava/lang/Object;
.source "ReportUserDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/ReportUserDialog$ReportReasonListener;
    }
.end annotation


# static fields
.field static reportUserOrListingListener:Landroid/view/View$OnClickListener;


# instance fields
.field alertView:Landroid/view/View;

.field dialog:Landroid/app/AlertDialog;

.field layoutId:I

.field listener:Lcom/poshmark/utils/ReportUserDialog$ReportReasonListener;

.field parent:Landroid/app/Activity;

.field reasonButtonListener:Landroid/view/View$OnClickListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 75
    new-instance v0, Lcom/poshmark/utils/ReportUserDialog$2;

    invoke-direct {v0}, Lcom/poshmark/utils/ReportUserDialog$2;-><init>()V

    sput-object v0, Lcom/poshmark/utils/ReportUserDialog;->reportUserOrListingListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/poshmark/utils/ReportUserDialog$ReportReasonListener;)V
    .locals 3
    .param p1, "parentActivity"    # Landroid/app/Activity;
    .param p2, "listener"    # Lcom/poshmark/utils/ReportUserDialog$ReportReasonListener;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    new-instance v0, Lcom/poshmark/utils/ReportUserDialog$1;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/ReportUserDialog$1;-><init>(Lcom/poshmark/utils/ReportUserDialog;)V

    iput-object v0, p0, Lcom/poshmark/utils/ReportUserDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    .line 22
    iget v0, p0, Lcom/poshmark/utils/ReportUserDialog;->layoutId:I

    iput v0, p0, Lcom/poshmark/utils/ReportUserDialog;->layoutId:I

    .line 23
    iput-object p1, p0, Lcom/poshmark/utils/ReportUserDialog;->parent:Landroid/app/Activity;

    .line 24
    iput-object p2, p0, Lcom/poshmark/utils/ReportUserDialog;->listener:Lcom/poshmark/utils/ReportUserDialog$ReportReasonListener;

    .line 26
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0300a7

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/ReportUserDialog;->alertView:Landroid/view/View;

    .line 27
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->alertView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const-string v1, "Report User"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/ReportUserDialog;->dialog:Landroid/app/AlertDialog;

    .line 32
    invoke-direct {p0}, Lcom/poshmark/utils/ReportUserDialog;->setupButtonHandlers()V

    .line 34
    return-void
.end method

.method private setupButtonHandlers()V
    .locals 3

    .prologue
    .line 37
    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0274

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 38
    .local v0, "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 39
    const-string v1, "replica"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 41
    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0275

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 42
    .restart local v0    # "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 43
    const-string v1, "offline_transaction"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 45
    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0276

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 46
    .restart local v0    # "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 47
    const-string v1, "not_allowed_items"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 49
    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0277

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 50
    .restart local v0    # "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 51
    const-string v1, "spam"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 53
    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->alertView:Landroid/view/View;

    const v2, 0x7f0c0278

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 54
    .restart local v0    # "button":Landroid/widget/Button;
    iget-object v1, p0, Lcom/poshmark/utils/ReportUserDialog;->reasonButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 55
    const-string v1, "harassment"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 57
    return-void
.end method


# virtual methods
.method public show()V
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/poshmark/utils/ReportUserDialog;->dialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 61
    return-void
.end method
