.class public Lco/vine/android/views/SquareMatch;
.super Ljava/lang/Object;
.source "SquareMatch.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/views/SquareMatch$1;,
        Lco/vine/android/views/SquareMatch$SquareMatchRules;,
        Lco/vine/android/views/SquareMatch$SquareMatchView;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    return-void
.end method

.method public static setMatchingLayoutAction(Lco/vine/android/views/SquareMatch$SquareMatchView;)V
    .locals 2
    .param p0, "view"    # Lco/vine/android/views/SquareMatch$SquareMatchView;

    .prologue
    .line 66
    invoke-interface {p0}, Lco/vine/android/views/SquareMatch$SquareMatchView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 67
    .local v0, "params":Landroid/view/ViewGroup$LayoutParams;
    invoke-interface {p0}, Lco/vine/android/views/SquareMatch$SquareMatchView;->getMeasuredHeight()I

    move-result v1

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 68
    invoke-interface {p0}, Lco/vine/android/views/SquareMatch$SquareMatchView;->getMeasuredWidth()I

    move-result v1

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 69
    invoke-interface {p0, v0}, Lco/vine/android/views/SquareMatch$SquareMatchView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 70
    return-void
.end method

.method public static setupSquareMatchView(Lco/vine/android/views/SquareMatch$SquareMatchView;)V
    .locals 5
    .param p0, "view"    # Lco/vine/android/views/SquareMatch$SquareMatchView;

    .prologue
    .line 41
    invoke-interface {p0}, Lco/vine/android/views/SquareMatch$SquareMatchView;->getMeasuredWidth()I

    move-result v2

    .line 42
    .local v2, "width":I
    invoke-interface {p0}, Lco/vine/android/views/SquareMatch$SquareMatchView;->getMeasuredHeight()I

    move-result v0

    .line 43
    .local v0, "height":I
    if-eq v2, v0, :cond_0

    .line 45
    sget-object v3, Lco/vine/android/views/SquareMatch$1;->$SwitchMap$co$vine$android$views$SquareMatch$SquareMatchRules:[I

    invoke-interface {p0}, Lco/vine/android/views/SquareMatch$SquareMatchView;->getMatchSpec()Lco/vine/android/views/SquareMatch$SquareMatchRules;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/views/SquareMatch$SquareMatchRules;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 57
    if-le v2, v0, :cond_2

    move v1, v0

    .line 60
    .local v1, "size":I
    :goto_0
    invoke-interface {p0, v1}, Lco/vine/android/views/SquareMatch$SquareMatchView;->setMeasuredDimension(I)V

    .line 61
    invoke-interface {p0}, Lco/vine/android/views/SquareMatch$SquareMatchView;->getMatchLayoutRunnable()Ljava/lang/Runnable;

    move-result-object v3

    invoke-interface {p0, v3}, Lco/vine/android/views/SquareMatch$SquareMatchView;->post(Ljava/lang/Runnable;)Z

    .line 63
    .end local v1    # "size":I
    :cond_0
    return-void

    .line 47
    :pswitch_0
    move v1, v2

    .line 48
    .restart local v1    # "size":I
    goto :goto_0

    .line 50
    .end local v1    # "size":I
    :pswitch_1
    move v1, v0

    .line 51
    .restart local v1    # "size":I
    goto :goto_0

    .line 53
    .end local v1    # "size":I
    :pswitch_2
    if-le v2, v0, :cond_1

    move v1, v2

    .line 54
    .restart local v1    # "size":I
    :goto_1
    goto :goto_0

    .end local v1    # "size":I
    :cond_1
    move v1, v0

    .line 53
    goto :goto_1

    :cond_2
    move v1, v2

    .line 57
    goto :goto_0

    .line 45
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
