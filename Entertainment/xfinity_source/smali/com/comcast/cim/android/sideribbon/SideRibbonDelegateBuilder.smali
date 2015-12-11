.class public Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
.super Ljava/lang/Object;
.source "SideRibbonDelegateBuilder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;
    }
.end annotation


# instance fields
.field private final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private configuration:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V
    .locals 1
    .param p1, "accessibilityUtil"    # Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 19
    new-instance v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;

    invoke-direct {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->configuration:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;

    .line 20
    return-void
.end method


# virtual methods
.method public build(Landroid/app/Activity;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 23
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->build(Landroid/content/Context;Landroid/view/ViewGroup;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    move-result-object v0

    return-object v0
.end method

.method public build(Landroid/content/Context;Landroid/view/ViewGroup;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "contentContainerParent"    # Landroid/view/ViewGroup;

    .prologue
    .line 27
    new-instance v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->configuration:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;

    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-direct {v0, p1, p2, v1, v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;-><init>(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V

    return-object v0
.end method

.method public setBackgroundResource(Ljava/lang/Integer;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
    .locals 1
    .param p1, "backgroundResource"    # Ljava/lang/Integer;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->configuration:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;

    # setter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->backgroundResource:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->access$302(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;Ljava/lang/Integer;)Ljava/lang/Integer;

    .line 47
    return-object p0
.end method

.method public setRibbonWidth(I)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
    .locals 1
    .param p1, "width"    # I

    .prologue
    .line 31
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->configuration:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;

    # setter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->ribbonWidth:I
    invoke-static {v0, p1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->access$002(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;I)I

    .line 32
    return-object p0
.end method

.method public setSlideDuration(J)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
    .locals 1
    .param p1, "slideDuration"    # J

    .prologue
    .line 36
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->configuration:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;

    # setter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->slideDuration:J
    invoke-static {v0, p1, p2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->access$102(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;J)J

    .line 37
    return-object p0
.end method
