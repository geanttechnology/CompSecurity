.class public Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;
.super Ljava/lang/Object;
.source "SlidingActivityHelper.java"

# interfaces
.implements Landroid/view/View$OnDragListener;
.implements Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnClosedListener;
.implements Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnCloseListener;
.implements Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnOpenedListener;
.implements Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnOpenListener;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MenuStateHandler"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;
    }
.end annotation


# instance fields
.field private final mListener:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;


# direct methods
.method public constructor <init>(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;

    .prologue
    .line 230
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 231
    iput-object p1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;->mListener:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;

    .line 232
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 261
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;->mListener:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;

    invoke-interface {v0, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;->onMenuClick(Landroid/view/View;)V

    .line 262
    return-void
.end method

.method public onClose()V
    .locals 1

    .prologue
    .line 246
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;->mListener:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;

    invoke-interface {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;->onMenuClose()V

    .line 247
    return-void
.end method

.method public onClosed()V
    .locals 1

    .prologue
    .line 241
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;->mListener:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;

    invoke-interface {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;->onMenuClosed()V

    .line 242
    return-void
.end method

.method public onDrag(Landroid/view/View;Landroid/view/DragEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/DragEvent;

    .prologue
    .line 236
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;->mListener:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;

    invoke-interface {v0, p1, p2}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;->onMenuDrag(Landroid/view/View;Landroid/view/DragEvent;)Z

    move-result v0

    return v0
.end method

.method public onOpen()V
    .locals 1

    .prologue
    .line 256
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;->mListener:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;

    invoke-interface {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;->onMenuOpen()V

    .line 257
    return-void
.end method

.method public onOpened()V
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;->mListener:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;

    invoke-interface {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;->onMenuOpened()V

    .line 252
    return-void
.end method
