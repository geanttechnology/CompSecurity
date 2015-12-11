.class public Lcom/poshmark/utils/FragmentStack;
.super Ljava/lang/Object;
.source "FragmentStack.java"


# static fields
.field public static FragmentStack:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Lcom/poshmark/ui/fragments/PMFragment;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    sput-object v0, Lcom/poshmark/utils/FragmentStack;->FragmentStack:Ljava/util/Stack;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static peek()Lcom/poshmark/ui/fragments/PMFragment;
    .locals 1

    .prologue
    .line 20
    sget-object v0, Lcom/poshmark/utils/FragmentStack;->FragmentStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFragment;

    return-object v0
.end method

.method public static pop()Lcom/poshmark/ui/fragments/PMFragment;
    .locals 1

    .prologue
    .line 16
    sget-object v0, Lcom/poshmark/utils/FragmentStack;->FragmentStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFragment;

    return-object v0
.end method

.method public static push(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 1
    .param p0, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 12
    sget-object v0, Lcom/poshmark/utils/FragmentStack;->FragmentStack:Ljava/util/Stack;

    invoke-virtual {v0, p0}, Ljava/util/Stack;->add(Ljava/lang/Object;)Z

    .line 13
    return-void
.end method
