.class public interface abstract Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;
.super Ljava/lang/Object;
.source "SwipeDetector.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Listener"
.end annotation


# virtual methods
.method public abstract onDown(Landroid/view/MotionEvent;)Z
.end method

.method public abstract onMove(FFLandroid/view/MotionEvent;FF)Z
.end method

.method public abstract onSwipe(FFLandroid/view/MotionEvent;FF)Z
.end method
