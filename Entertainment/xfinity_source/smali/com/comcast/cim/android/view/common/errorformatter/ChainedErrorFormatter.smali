.class public Lcom/comcast/cim/android/view/common/errorformatter/ChainedErrorFormatter;
.super Ljava/lang/Object;
.source "ChainedErrorFormatter.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;


# instance fields
.field private final formatterChain:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 10
    .local p1, "formatterChain":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 12
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/errorformatter/ChainedErrorFormatter;->formatterChain:Ljava/util/List;

    .line 13
    return-void
.end method


# virtual methods
.method public formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .locals 4
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 17
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/errorformatter/ChainedErrorFormatter;->formatterChain:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 18
    .local v1, "formatter":Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    invoke-interface {v1, p1}, Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v0

    .line 19
    .local v0, "formatted":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    if-eqz v0, :cond_0

    .line 23
    .end local v0    # "formatted":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .end local v1    # "formatter":Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
