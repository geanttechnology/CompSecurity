.class public Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;
.super Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
.source "ModelViewEntry.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Widget:",
        "Landroid/view/View;",
        ":",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
        "<TModel;>;Model:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;"
    }
.end annotation


# static fields
.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field dcmLog:Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private final layoutParams:Landroid/view/ViewGroup$LayoutParams;

.field private model:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TModel;"
        }
    .end annotation
.end field

.field private final viewClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TWidget;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>(ILjava/lang/Class;Ljava/lang/Object;)V
    .locals 1
    .param p1, "type"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/Class",
            "<TWidget;>;TModel;)V"
        }
    .end annotation

    .prologue
    .line 43
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;, "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry<TWidget;TModel;>;"
    .local p2, "viewClass":Ljava/lang/Class;, "Ljava/lang/Class<TWidget;>;"
    .local p3, "model":Ljava/lang/Object;, "TModel;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;-><init>(ILjava/lang/Class;Ljava/lang/Object;Landroid/view/ViewGroup$LayoutParams;)V

    .line 44
    return-void
.end method

.method public constructor <init>(ILjava/lang/Class;Ljava/lang/Object;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 0
    .param p1, "type"    # I
    .param p4, "layoutParams"    # Landroid/view/ViewGroup$LayoutParams;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/Class",
            "<TWidget;>;TModel;",
            "Landroid/view/ViewGroup$LayoutParams;",
            ")V"
        }
    .end annotation

    .prologue
    .line 36
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;, "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry<TWidget;TModel;>;"
    .local p2, "viewClass":Ljava/lang/Class;, "Ljava/lang/Class<TWidget;>;"
    .local p3, "model":Ljava/lang/Object;, "TModel;"
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;-><init>(I)V

    .line 37
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->viewClass:Ljava/lang/Class;

    .line 38
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->model:Ljava/lang/Object;

    .line 39
    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->layoutParams:Landroid/view/ViewGroup$LayoutParams;

    .line 40
    return-void
.end method

.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry",
            "<TWidget;TModel;>;)V"
        }
    .end annotation

    .prologue
    .line 47
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;, "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry<TWidget;TModel;>;"
    .local p1, "entry":Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;, "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry<TWidget;TModel;>;"
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->getType()I

    move-result v0

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->getViewClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->getModel()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;-><init>(ILjava/lang/Class;Ljava/lang/Object;Landroid/view/ViewGroup$LayoutParams;)V

    .line 48
    return-void
.end method

.method public static create(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;
    .locals 1
    .param p0, "type"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<Widget:",
            "Landroid/view/View;",
            ":",
            "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
            "<TModel;>;Model:",
            "Ljava/lang/Object;",
            ">(I",
            "Ljava/lang/Class",
            "<TWidget;>;TModel;)",
            "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry",
            "<TWidget;TModel;>;"
        }
    .end annotation

    .prologue
    .line 52
    .local p1, "viewClass":Ljava/lang/Class;, "Ljava/lang/Class<TWidget;>;"
    .local p2, "model":Ljava/lang/Object;, "TModel;"
    new-instance v0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;-><init>(ILjava/lang/Class;Ljava/lang/Object;)V

    return-object v0
.end method


# virtual methods
.method public buildView(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 104
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;, "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry<TWidget;TModel;>;"
    if-eqz p1, :cond_0

    .line 106
    :try_start_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->viewClass:Ljava/lang/Class;

    invoke-virtual {v1, p1}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    check-cast v1, Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->model:Ljava/lang/Object;

    invoke-interface {v1, v2}, Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;->build(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    .line 111
    :cond_0
    :goto_0
    return-void

    .line 107
    :catch_0
    move-exception v0

    .line 108
    .local v0, "e":Ljava/lang/ClassCastException;
    sget-object v1, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v2, "Recycled view has unexpected type"

    invoke-interface {v1, v2, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public createView(Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 73
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;, "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry<TWidget;TModel;>;"
    const/4 v2, 0x0

    .line 74
    .local v2, "error":Ljava/lang/Exception;
    const/4 v3, 0x0

    .line 77
    .local v3, "view":Landroid/view/View;, "TWidget;"
    :try_start_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->viewClass:Ljava/lang/Class;

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Class;

    const/4 v6, 0x0

    const-class v7, Landroid/content/Context;

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const-class v7, Landroid/util/AttributeSet;

    aput-object v7, v5, v6

    invoke-virtual {v4, v5}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v4

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const/4 v7, 0x0

    aput-object v7, v5, v6

    invoke-virtual {v4, v5}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    move-object v0, v4

    check-cast v0, Landroid/view/View;

    move-object v3, v0
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_4

    .line 91
    :goto_0
    if-eqz v2, :cond_0

    .line 92
    sget-object v4, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "View instantiation error for viewClass "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->viewClass:Ljava/lang/Class;

    invoke-virtual {v6}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 95
    :cond_0
    if-eqz v3, :cond_1

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->layoutParams:Landroid/view/ViewGroup$LayoutParams;

    if-eqz v4, :cond_1

    .line 96
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->layoutParams:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v3, v4}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 99
    :cond_1
    return-object v3

    .line 79
    :catch_0
    move-exception v1

    .line 80
    .local v1, "e":Ljava/lang/InstantiationException;
    move-object v2, v1

    .line 89
    goto :goto_0

    .line 81
    .end local v1    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v1

    .line 82
    .local v1, "e":Ljava/lang/IllegalAccessException;
    move-object v2, v1

    .line 89
    goto :goto_0

    .line 83
    .end local v1    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v1

    .line 84
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    move-object v2, v1

    .line 89
    goto :goto_0

    .line 85
    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    :catch_3
    move-exception v1

    .line 86
    .local v1, "e":Ljava/lang/reflect/InvocationTargetException;
    move-object v2, v1

    .line 89
    goto :goto_0

    .line 87
    .end local v1    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_4
    move-exception v1

    .line 88
    .local v1, "e":Ljava/lang/NoSuchMethodException;
    move-object v2, v1

    goto :goto_0
.end method

.method public getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    .prologue
    .line 68
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;, "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry<TWidget;TModel;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->layoutParams:Landroid/view/ViewGroup$LayoutParams;

    return-object v0
.end method

.method public getModel()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TModel;"
        }
    .end annotation

    .prologue
    .line 60
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;, "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry<TWidget;TModel;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->model:Ljava/lang/Object;

    return-object v0
.end method

.method public getViewClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<TWidget;>;"
        }
    .end annotation

    .prologue
    .line 56
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;, "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry<TWidget;TModel;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->viewClass:Ljava/lang/Class;

    return-object v0
.end method

.method public setModel(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TModel;)V"
        }
    .end annotation

    .prologue
    .line 64
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;, "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry<TWidget;TModel;>;"
    .local p1, "model":Ljava/lang/Object;, "TModel;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->model:Ljava/lang/Object;

    .line 65
    return-void
.end method
