.class final Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask$1;
.super Ljava/lang/Object;
.source "AuthenticationAsyncTask.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask;->getOnCancelListener(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Landroid/content/DialogInterface$OnCancelListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$activity:Lcom/comcast/cim/android/authentication/AuthenticationActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask$1;->val$activity:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationAsyncTask$1;->val$activity:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->hideSigningInSpinner()V

    .line 41
    return-void
.end method
