.class Lcom/kochava/android/tracker/KochavaWebAdView$MyPictureListener;
.super Ljava/lang/Object;
.source "KochavaWebAdView.java"

# interfaces
.implements Landroid/webkit/WebView$PictureListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/kochava/android/tracker/KochavaWebAdView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyPictureListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/kochava/android/tracker/KochavaWebAdView;


# direct methods
.method private constructor <init>(Lcom/kochava/android/tracker/KochavaWebAdView;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/kochava/android/tracker/KochavaWebAdView$MyPictureListener;->this$0:Lcom/kochava/android/tracker/KochavaWebAdView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/kochava/android/tracker/KochavaWebAdView;Lcom/kochava/android/tracker/KochavaWebAdView$MyPictureListener;)V
    .locals 0

    .prologue
    .line 225
    invoke-direct {p0, p1}, Lcom/kochava/android/tracker/KochavaWebAdView$MyPictureListener;-><init>(Lcom/kochava/android/tracker/KochavaWebAdView;)V

    return-void
.end method


# virtual methods
.method public onNewPicture(Landroid/webkit/WebView;Landroid/graphics/Picture;)V
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "arg1"    # Landroid/graphics/Picture;

    .prologue
    .line 230
    iget-object v0, p0, Lcom/kochava/android/tracker/KochavaWebAdView$MyPictureListener;->this$0:Lcom/kochava/android/tracker/KochavaWebAdView;

    iget-object v0, v0, Lcom/kochava/android/tracker/KochavaWebAdView;->mDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 231
    iget-object v0, p0, Lcom/kochava/android/tracker/KochavaWebAdView$MyPictureListener;->this$0:Lcom/kochava/android/tracker/KochavaWebAdView;

    iget-object v0, v0, Lcom/kochava/android/tracker/KochavaWebAdView;->mDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 232
    :cond_0
    return-void
.end method
