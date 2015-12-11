.class Lco/vine/android/SettingsFragment$4;
.super Ljava/lang/Object;
.source "SettingsFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/SettingsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/SettingsFragment;


# direct methods
.method constructor <init>(Lco/vine/android/SettingsFragment;)V
    .locals 0

    .prologue
    .line 441
    iput-object p1, p0, Lco/vine/android/SettingsFragment$4;->this$0:Lco/vine/android/SettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 458
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 444
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 448
    iget-object v0, p0, Lco/vine/android/SettingsFragment$4;->this$0:Lco/vine/android/SettingsFragment;

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    # setter for: Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;
    invoke-static {v0, v1}, Lco/vine/android/SettingsFragment;->access$402(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 449
    iget-object v0, p0, Lco/vine/android/SettingsFragment$4;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mOriginalEmail:Ljava/lang/String;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$500(Lco/vine/android/SettingsFragment;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SettingsFragment$4;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mOriginalPhone:Ljava/lang/String;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$600(Lco/vine/android/SettingsFragment;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/SettingsFragment$4;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$400(Lco/vine/android/SettingsFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 450
    iget-object v0, p0, Lco/vine/android/SettingsFragment$4;->this$0:Lco/vine/android/SettingsFragment;

    const/4 v1, 0x0

    # setter for: Lco/vine/android/SettingsFragment;->mIsEmailVerified:Z
    invoke-static {v0, v1}, Lco/vine/android/SettingsFragment;->access$702(Lco/vine/android/SettingsFragment;Z)Z

    .line 454
    :goto_0
    return-void

    .line 452
    :cond_0
    iget-object v0, p0, Lco/vine/android/SettingsFragment$4;->this$0:Lco/vine/android/SettingsFragment;

    iget-object v1, p0, Lco/vine/android/SettingsFragment$4;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mOriginalEmailVerified:Z
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$800(Lco/vine/android/SettingsFragment;)Z

    move-result v1

    # setter for: Lco/vine/android/SettingsFragment;->mIsEmailVerified:Z
    invoke-static {v0, v1}, Lco/vine/android/SettingsFragment;->access$702(Lco/vine/android/SettingsFragment;Z)Z

    goto :goto_0
.end method
