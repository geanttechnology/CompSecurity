.class public Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;
.super Ljava/lang/Object;
.source "SeriesCombinedTaskExecutorFactory.java"


# instance fields
.field private final cachingBookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO",
            "<*>;"
        }
    .end annotation
.end field

.field private final dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field private final entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private final providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;)V
    .locals 0
    .param p1, "providerFactory"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;",
            "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p2, "entitlementCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    .local p3, "dibicResourceCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    .local p4, "cachingBookmarkDAO":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<*>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 26
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 27
    iput-object p3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 28
    iput-object p4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->cachingBookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    .line 29
    return-void
.end method


# virtual methods
.method public create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;)",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 32
    .local p1, "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->cachingBookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    invoke-direct {v1, v2, p1, v3, v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    return-object v0
.end method
