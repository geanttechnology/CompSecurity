.class public Lco/vine/android/PostOptionsDialogActivity$Result;
.super Ljava/lang/Object;
.source "PostOptionsDialogActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/PostOptionsDialogActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Result"
.end annotation


# instance fields
.field public final intent:Landroid/content/Intent;

.field public final request:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/content/Intent;)V
    .locals 0
    .param p1, "request"    # Ljava/lang/String;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 342
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 343
    iput-object p1, p0, Lco/vine/android/PostOptionsDialogActivity$Result;->request:Ljava/lang/String;

    .line 344
    iput-object p2, p0, Lco/vine/android/PostOptionsDialogActivity$Result;->intent:Landroid/content/Intent;

    .line 345
    return-void
.end method
