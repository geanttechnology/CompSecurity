.class Lco/vine/android/SettingsFragment$1;
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
    .line 383
    iput-object p1, p0, Lco/vine/android/SettingsFragment$1;->this$0:Lco/vine/android/SettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 395
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 386
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 390
    iget-object v0, p0, Lco/vine/android/SettingsFragment$1;->this$0:Lco/vine/android/SettingsFragment;

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    # setter for: Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;
    invoke-static {v0, v1}, Lco/vine/android/SettingsFragment;->access$102(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 391
    return-void
.end method
