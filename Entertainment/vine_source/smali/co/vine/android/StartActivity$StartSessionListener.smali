.class Lco/vine/android/StartActivity$StartSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "StartActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/StartActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "StartSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/StartActivity;


# direct methods
.method constructor <init>(Lco/vine/android/StartActivity;)V
    .locals 0

    .prologue
    .line 467
    iput-object p1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckTwitterComplete(Ljava/lang/String;ILjava/lang/String;IZLco/vine/android/api/VineUser;Lco/vine/android/api/VineLogin;)V
    .locals 11
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "errorCode"    # I
    .param p5, "accountExists"    # Z
    .param p6, "user"    # Lco/vine/android/api/VineUser;
    .param p7, "login"    # Lco/vine/android/api/VineLogin;

    .prologue
    .line 471
    if-eqz p5, :cond_1

    const/16 v1, 0xc8

    if-ne p2, v1, :cond_1

    .line 472
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    invoke-virtual {v1}, Lco/vine/android/StartActivity;->dismissDialog()V

    .line 475
    :try_start_0
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    iget-object v1, v1, Lco/vine/android/StartActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    iget-object v2, v2, Lco/vine/android/StartActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    move-object/from16 v0, p6

    iget-object v4, v0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    const/4 v5, 0x0

    move-object/from16 v0, p6

    iget-object v7, v0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    move v3, p2

    move-object/from16 v6, p7

    invoke-virtual/range {v1 .. v7}, Lco/vine/android/client/AppController;->loginComplete(Lco/vine/android/client/Session;ILjava/lang/String;Ljava/lang/String;Lco/vine/android/api/VineLogin;Ljava/lang/String;)Lco/vine/android/api/VineLogin;
    :try_end_0
    .catch Lco/vine/android/VineLoggingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 483
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    # getter for: Lco/vine/android/StartActivity;->mLoginRequest:Z
    invoke-static {v1}, Lco/vine/android/StartActivity;->access$300(Lco/vine/android/StartActivity;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 484
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Lco/vine/android/StartActivity;->setResult(I)V

    .line 485
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    invoke-virtual {v1}, Lco/vine/android/StartActivity;->finish()V

    .line 508
    :goto_0
    return-void

    .line 477
    :catch_0
    move-exception v8

    .line 478
    .local v8, "e":Lco/vine/android/VineLoggingException;
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    const v2, 0x7f0e00d7

    invoke-static {v1, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 479
    invoke-static {v8}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 480
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    invoke-virtual {v1}, Lco/vine/android/StartActivity;->finish()V

    goto :goto_0

    .line 487
    .end local v8    # "e":Lco/vine/android/VineLoggingException;
    :cond_0
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    invoke-static {v1}, Lco/vine/android/StartActivity;->toStart(Landroid/content/Context;)V

    goto :goto_0

    .line 490
    :cond_1
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    invoke-virtual {v1}, Lco/vine/android/StartActivity;->dismissDialog()V

    .line 491
    const/16 v1, 0x190

    if-ne p2, v1, :cond_2

    .line 493
    new-instance v9, Landroid/os/Bundle;

    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    .line 494
    .local v9, "extras":Landroid/os/Bundle;
    const-string v1, "user"

    move-object/from16 v0, p7

    invoke-virtual {v9, v1, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 495
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    iget-object v2, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    invoke-static {v2, v9}, Lco/vine/android/SignUpPagerActivity;->getIntent(Landroid/content/Context;Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/StartActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 496
    .end local v9    # "extras":Landroid/os/Bundle;
    :cond_2
    sget-object v1, Lco/vine/android/api/VineError$VineKnownErrors;->ACCOUNT_DEACTIVATED:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v1, v1, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    if-ne p4, v1, :cond_3

    .line 497
    const/4 v1, 0x1

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v10

    .line 499
    .local v10, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v1, 0x7f0e01ce

    invoke-virtual {v10, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 500
    const v1, 0x7f0e01cf

    invoke-virtual {v10, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 501
    const v1, 0x7f0e0057

    invoke-virtual {v10, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 502
    const v1, 0x7f0e01cd

    invoke-virtual {v10, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 503
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    invoke-virtual {v1}, Lco/vine/android/StartActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v10, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    goto :goto_0

    .line 505
    .end local v10    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_3
    iget-object v1, p0, Lco/vine/android/StartActivity$StartSessionListener;->this$0:Lco/vine/android/StartActivity;

    invoke-static {v1, p3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0
.end method
