.class public Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;


# direct methods
.method public constructor <init>(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V
    .locals 0

    .prologue
    .line 565
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v2, 0x0

    .line 569
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 570
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$200(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/facebook/internal/SessionTracker;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/internal/SessionTracker;->getOpenSession()Lcom/facebook/Session;

    move-result-object v3

    .line 571
    if-eqz v3, :cond_3

    .line 573
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->confirmLogout:Z
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$500(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 575
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v4, 0x7f080032

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 576
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v5, 0x7f080033

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 578
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$300(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/facebook/model/GraphUser;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$300(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/facebook/model/GraphUser;

    move-result-object v1

    invoke-interface {v1}, Lcom/facebook/model/GraphUser;->getName()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 579
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v6, 0x7f080030

    invoke-virtual {v1, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v6, v9, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;
    invoke-static {v8}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$300(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/facebook/model/GraphUser;

    move-result-object v8

    invoke-interface {v8}, Lcom/facebook/model/GraphUser;->getName()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v1, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 583
    :goto_0
    new-instance v6, Landroid/app/AlertDialog$Builder;

    invoke-direct {v6, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 584
    invoke-virtual {v6, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0, v9}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener$1;

    invoke-direct {v1, p0, v3}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener$1;-><init>(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;Lcom/facebook/Session;)V

    invoke-virtual {v0, v4, v1}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0, v5, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 592
    invoke-virtual {v6}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 625
    :cond_0
    :goto_1
    return-void

    .line 581
    :cond_1
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v6, 0x7f080031

    invoke-virtual {v1, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 594
    :cond_2
    invoke-virtual {v3}, Lcom/facebook/Session;->closeAndClearTokenInformation()V

    goto :goto_1

    .line 597
    :cond_3
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$200(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/facebook/internal/SessionTracker;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/internal/SessionTracker;->getSession()Lcom/facebook/Session;

    move-result-object v1

    .line 598
    if-eqz v1, :cond_4

    invoke-virtual {v1}, Lcom/facebook/Session;->getState()Lcom/facebook/SessionState;

    move-result-object v3

    invoke-virtual {v3}, Lcom/facebook/SessionState;->isClosed()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 599
    :cond_4
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$200(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/facebook/internal/SessionTracker;

    move-result-object v1

    invoke-virtual {v1, v2}, Lcom/facebook/internal/SessionTracker;->setSession(Lcom/facebook/Session;)V

    .line 600
    new-instance v1, Lcom/facebook/Session$Builder;

    invoke-direct {v1, v0}, Lcom/facebook/Session$Builder;-><init>(Landroid/content/Context;)V

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->applicationId:Ljava/lang/String;
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$600(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/facebook/Session$Builder;->setApplicationId(Ljava/lang/String;)Lcom/facebook/Session$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/Session$Builder;->build()Lcom/facebook/Session;

    move-result-object v1

    .line 601
    invoke-static {v1}, Lcom/facebook/Session;->setActiveSession(Lcom/facebook/Session;)V

    .line 604
    :cond_5
    invoke-virtual {v1}, Lcom/facebook/Session;->isOpened()Z

    move-result v3

    if-nez v3, :cond_0

    .line 606
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->parentFragment:Landroid/support/v4/app/Fragment;
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$700(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Landroid/support/v4/app/Fragment;

    move-result-object v3

    if-eqz v3, :cond_6

    .line 607
    new-instance v0, Lcom/facebook/Session$OpenRequest;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->parentFragment:Landroid/support/v4/app/Fragment;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$700(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/facebook/Session$OpenRequest;-><init>(Landroid/support/v4/app/Fragment;)V

    .line 612
    :goto_2
    if-eqz v0, :cond_0

    .line 613
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$800(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    move-result-object v2

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->defaultAudience:Lcom/facebook/SessionDefaultAudience;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->access$900(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/facebook/SessionDefaultAudience;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/facebook/Session$OpenRequest;->setDefaultAudience(Lcom/facebook/SessionDefaultAudience;)Lcom/facebook/Session$OpenRequest;

    .line 614
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$800(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    move-result-object v2

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->permissions:Ljava/util/List;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->access$1000(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/facebook/Session$OpenRequest;->setPermissions(Ljava/util/List;)Lcom/facebook/Session$OpenRequest;

    .line 615
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$800(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    move-result-object v2

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->loginBehavior:Lcom/facebook/SessionLoginBehavior;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->access$1100(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/facebook/SessionLoginBehavior;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/facebook/Session$OpenRequest;->setLoginBehavior(Lcom/facebook/SessionLoginBehavior;)Lcom/facebook/Session$OpenRequest;

    .line 617
    sget-object v2, Lcom/facebook/internal/SessionAuthorizationType;->PUBLISH:Lcom/facebook/internal/SessionAuthorizationType;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->access$800(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    move-result-object v3

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->authorizationType:Lcom/facebook/internal/SessionAuthorizationType;
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->access$1200(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/facebook/internal/SessionAuthorizationType;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/facebook/internal/SessionAuthorizationType;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 618
    invoke-virtual {v1, v0}, Lcom/facebook/Session;->openForPublish(Lcom/facebook/Session$OpenRequest;)V

    goto/16 :goto_1

    .line 608
    :cond_6
    instance-of v3, v0, Landroid/app/Activity;

    if-eqz v3, :cond_8

    .line 609
    new-instance v2, Lcom/facebook/Session$OpenRequest;

    check-cast v0, Landroid/app/Activity;

    invoke-direct {v2, v0}, Lcom/facebook/Session$OpenRequest;-><init>(Landroid/app/Activity;)V

    move-object v0, v2

    goto :goto_2

    .line 620
    :cond_7
    invoke-virtual {v1, v0}, Lcom/facebook/Session;->openForRead(Lcom/facebook/Session$OpenRequest;)V

    goto/16 :goto_1

    :cond_8
    move-object v0, v2

    goto :goto_2
.end method
