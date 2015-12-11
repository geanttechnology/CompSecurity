.class Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;
.super Ljava/lang/ThreadLocal;
.source "AndroidProfiler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/profiling/AndroidProfiler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ThreadLocalStack"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/ThreadLocal",
        "<",
        "Ljava/util/Stack",
        "<TT;>;>;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 98
    .local p0, "this":Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;, "Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack<TT;>;"
    invoke-direct {p0}, Ljava/lang/ThreadLocal;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/android/profiling/AndroidProfiler$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/android/profiling/AndroidProfiler$1;

    .prologue
    .line 98
    .local p0, "this":Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;, "Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack<TT;>;"
    invoke-direct {p0}, Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic initialValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 98
    .local p0, "this":Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;, "Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;->initialValue()Ljava/util/Stack;

    move-result-object v0

    return-object v0
.end method

.method protected initialValue()Ljava/util/Stack;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Stack",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 103
    .local p0, "this":Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;, "Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack<TT;>;"
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    return-object v0
.end method
