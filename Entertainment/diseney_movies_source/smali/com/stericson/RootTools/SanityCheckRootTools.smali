.class public Lcom/stericson/RootTools/SanityCheckRootTools;
.super Landroid/app/Activity;
.source "SanityCheckRootTools.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;,
        Lcom/stericson/RootTools/SanityCheckRootTools$TestHandler;
    }
.end annotation


# instance fields
.field private mPDialog:Landroid/app/ProgressDialog;

.field private mScrollView:Landroid/widget/ScrollView;

.field private mTextView:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/stericson/RootTools/SanityCheckRootTools;)Landroid/app/ProgressDialog;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mPDialog:Landroid/app/ProgressDialog;

    return-object v0
.end method

.method static synthetic access$1(Lcom/stericson/RootTools/SanityCheckRootTools;)Landroid/widget/ScrollView;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mScrollView:Landroid/widget/ScrollView;

    return-object v0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x0

    .line 47
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 49
    new-instance v3, Landroid/widget/TextView;

    invoke-direct {v3, p0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mTextView:Landroid/widget/TextView;

    .line 50
    iget-object v3, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mTextView:Landroid/widget/TextView;

    const-string v4, ""

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 51
    new-instance v3, Landroid/widget/ScrollView;

    invoke-direct {v3, p0}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mScrollView:Landroid/widget/ScrollView;

    .line 52
    iget-object v3, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mScrollView:Landroid/widget/ScrollView;

    iget-object v4, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/ScrollView;->addView(Landroid/view/View;)V

    .line 53
    iget-object v3, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mScrollView:Landroid/widget/ScrollView;

    invoke-virtual {p0, v3}, Lcom/stericson/RootTools/SanityCheckRootTools;->setContentView(Landroid/view/View;)V

    .line 56
    const-string v2, "?"

    .line 59
    .local v2, "version":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p0}, Lcom/stericson/RootTools/SanityCheckRootTools;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/stericson/RootTools/SanityCheckRootTools;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 60
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v2, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    .line 64
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "SanityCheckRootTools v "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/stericson/RootTools/SanityCheckRootTools;->print(Ljava/lang/CharSequence;)V

    .line 66
    :try_start_1
    invoke-static {}, Lcom/stericson/RootTools/RootTools;->isAccessGiven()Z

    move-result v3

    if-nez v3, :cond_0

    .line 67
    const-string v3, "ERROR: No root access to this device.\n"

    invoke-virtual {p0, v3}, Lcom/stericson/RootTools/SanityCheckRootTools;->print(Ljava/lang/CharSequence;)V
    :try_end_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_0

    .line 81
    :goto_1
    return-void

    .line 70
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Ljava/util/concurrent/TimeoutException;
    const-string v3, "ERROR: could not determine root access to this device.\n"

    invoke-virtual {p0, v3}, Lcom/stericson/RootTools/SanityCheckRootTools;->print(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 76
    .end local v0    # "e":Ljava/util/concurrent/TimeoutException;
    :cond_0
    new-instance v3, Landroid/app/ProgressDialog;

    invoke-direct {v3, p0}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mPDialog:Landroid/app/ProgressDialog;

    .line 77
    iget-object v3, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mPDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v3, v6}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 78
    iget-object v3, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mPDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v3, v6}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 80
    new-instance v3, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;

    new-instance v4, Lcom/stericson/RootTools/SanityCheckRootTools$TestHandler;

    const/4 v5, 0x0

    invoke-direct {v4, p0, v5}, Lcom/stericson/RootTools/SanityCheckRootTools$TestHandler;-><init>(Lcom/stericson/RootTools/SanityCheckRootTools;Lcom/stericson/RootTools/SanityCheckRootTools$TestHandler;)V

    invoke-direct {v3, p0, p0, v4}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;-><init>(Lcom/stericson/RootTools/SanityCheckRootTools;Landroid/content/Context;Landroid/os/Handler;)V

    invoke-virtual {v3}, Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;->start()V

    goto :goto_1

    .line 61
    :catch_1
    move-exception v3

    goto :goto_0
.end method

.method protected print(Ljava/lang/CharSequence;)V
    .locals 2
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 84
    iget-object v0, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 85
    iget-object v0, p0, Lcom/stericson/RootTools/SanityCheckRootTools;->mScrollView:Landroid/widget/ScrollView;

    new-instance v1, Lcom/stericson/RootTools/SanityCheckRootTools$1;

    invoke-direct {v1, p0}, Lcom/stericson/RootTools/SanityCheckRootTools$1;-><init>(Lcom/stericson/RootTools/SanityCheckRootTools;)V

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->post(Ljava/lang/Runnable;)Z

    .line 90
    return-void
.end method
