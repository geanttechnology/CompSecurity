.class Lco/vine/android/DraftCameraPreviewFragment$1;
.super Ljava/lang/Object;
.source "DraftCameraPreviewFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/DraftCameraPreviewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/DraftCameraPreviewFragment;


# direct methods
.method constructor <init>(Lco/vine/android/DraftCameraPreviewFragment;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lco/vine/android/DraftCameraPreviewFragment$1;->this$0:Lco/vine/android/DraftCameraPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 30
    const/4 v0, 0x1

    return v0
.end method
