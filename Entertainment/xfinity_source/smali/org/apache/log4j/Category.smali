.class public Lorg/apache/log4j/Category;
.super Ljava/lang/Object;
.source "Category.java"

# interfaces
.implements Lorg/apache/log4j/spi/AppenderAttachable;


# static fields
.field private static final FQCN:Ljava/lang/String;

.field static class$org$apache$log4j$Category:Ljava/lang/Class;


# instance fields
.field aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

.field protected additive:Z

.field protected volatile level:Lorg/apache/log4j/Level;

.field protected name:Ljava/lang/String;

.field protected volatile parent:Lorg/apache/log4j/Category;

.field protected repository:Lorg/apache/log4j/spi/LoggerRepository;

.field protected resourceBundle:Ljava/util/ResourceBundle;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 118
    sget-object v0, Lorg/apache/log4j/Category;->class$org$apache$log4j$Category:Ljava/lang/Class;

    if-nez v0, :cond_0

    const-string v0, "org.apache.log4j.Category"

    invoke-static {v0}, Lorg/apache/log4j/Category;->class$(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    sput-object v0, Lorg/apache/log4j/Category;->class$org$apache$log4j$Category:Ljava/lang/Class;

    :goto_0
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/log4j/Category;->FQCN:Ljava/lang/String;

    return-void

    :cond_0
    sget-object v0, Lorg/apache/log4j/Category;->class$org$apache$log4j$Category:Ljava/lang/Class;

    goto :goto_0
.end method

.method protected constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 147
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 135
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/apache/log4j/Category;->additive:Z

    .line 148
    iput-object p1, p0, Lorg/apache/log4j/Category;->name:Ljava/lang/String;

    .line 149
    return-void
.end method

.method static class$(Ljava/lang/String;)Ljava/lang/Class;
    .locals 3
    .param p0, "x0"    # Ljava/lang/String;

    .prologue
    .line 118
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    :catch_0
    move-exception v0

    .local v0, "x1":Ljava/lang/ClassNotFoundException;
    new-instance v1, Ljava/lang/NoClassDefFoundError;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/NoClassDefFoundError;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private fireRemoveAppenderEvent(Lorg/apache/log4j/Appender;)V
    .locals 1
    .param p1, "appender"    # Lorg/apache/log4j/Appender;

    .prologue
    .line 868
    if-eqz p1, :cond_0

    .line 869
    iget-object v0, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    instance-of v0, v0, Lorg/apache/log4j/Hierarchy;

    if-eqz v0, :cond_1

    .line 870
    iget-object v0, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    check-cast v0, Lorg/apache/log4j/Hierarchy;

    invoke-virtual {v0, p0, p1}, Lorg/apache/log4j/Hierarchy;->fireRemoveAppenderEvent(Lorg/apache/log4j/Category;Lorg/apache/log4j/Appender;)V

    .line 875
    :cond_0
    :goto_0
    return-void

    .line 871
    :cond_1
    iget-object v0, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    instance-of v0, v0, Lorg/apache/log4j/spi/HierarchyEventListener;

    if-eqz v0, :cond_0

    .line 872
    iget-object v0, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    check-cast v0, Lorg/apache/log4j/spi/HierarchyEventListener;

    invoke-interface {v0, p0, p1}, Lorg/apache/log4j/spi/HierarchyEventListener;->removeAppenderEvent(Lorg/apache/log4j/Category;Lorg/apache/log4j/Appender;)V

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized addAppender(Lorg/apache/log4j/Appender;)V
    .locals 1
    .param p1, "newAppender"    # Lorg/apache/log4j/Appender;

    .prologue
    .line 161
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    if-nez v0, :cond_0

    .line 162
    new-instance v0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    invoke-direct {v0}, Lorg/apache/log4j/helpers/AppenderAttachableImpl;-><init>()V

    iput-object v0, p0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    .line 164
    :cond_0
    iget-object v0, p0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    invoke-virtual {v0, p1}, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->addAppender(Lorg/apache/log4j/Appender;)V

    .line 165
    iget-object v0, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    invoke-interface {v0, p0, p1}, Lorg/apache/log4j/spi/LoggerRepository;->fireAddAppenderEvent(Lorg/apache/log4j/Category;Lorg/apache/log4j/Appender;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 166
    monitor-exit p0

    return-void

    .line 161
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public callAppenders(Lorg/apache/log4j/spi/LoggingEvent;)V
    .locals 3
    .param p1, "event"    # Lorg/apache/log4j/spi/LoggingEvent;

    .prologue
    .line 200
    const/4 v1, 0x0

    .line 202
    .local v1, "writes":I
    move-object v0, p0

    .local v0, "c":Lorg/apache/log4j/Category;
    :goto_0
    if-eqz v0, :cond_1

    .line 204
    monitor-enter v0

    .line 205
    :try_start_0
    iget-object v2, v0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    if-eqz v2, :cond_0

    .line 206
    iget-object v2, v0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    invoke-virtual {v2, p1}, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appendLoopOnAppenders(Lorg/apache/log4j/spi/LoggingEvent;)I

    move-result v2

    add-int/2addr v1, v2

    .line 208
    :cond_0
    iget-boolean v2, v0, Lorg/apache/log4j/Category;->additive:Z

    if-nez v2, :cond_3

    .line 209
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 214
    :cond_1
    if-nez v1, :cond_2

    .line 215
    iget-object v2, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    invoke-interface {v2, p0}, Lorg/apache/log4j/spi/LoggerRepository;->emitNoAppenderWarning(Lorg/apache/log4j/Category;)V

    .line 217
    :cond_2
    return-void

    .line 211
    :cond_3
    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 202
    iget-object v0, v0, Lorg/apache/log4j/Category;->parent:Lorg/apache/log4j/Category;

    goto :goto_0

    .line 211
    :catchall_0
    move-exception v2

    :try_start_2
    monitor-exit v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method

.method declared-synchronized closeNestedAppenders()V
    .locals 3

    .prologue
    .line 226
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lorg/apache/log4j/Category;->getAllAppenders()Ljava/util/Enumeration;

    move-result-object v1

    .line 227
    .local v1, "enumeration":Ljava/util/Enumeration;
    if-eqz v1, :cond_1

    .line 228
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 229
    invoke-interface {v1}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/log4j/Appender;

    .line 230
    .local v0, "a":Lorg/apache/log4j/Appender;
    instance-of v2, v0, Lorg/apache/log4j/spi/AppenderAttachable;

    if-eqz v2, :cond_0

    .line 231
    invoke-interface {v0}, Lorg/apache/log4j/Appender;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 226
    .end local v0    # "a":Lorg/apache/log4j/Appender;
    .end local v1    # "enumeration":Ljava/util/Enumeration;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 235
    .restart local v1    # "enumeration":Ljava/util/Enumeration;
    :cond_1
    monitor-exit p0

    return-void
.end method

.method protected forcedLog(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 6
    .param p1, "fqcn"    # Ljava/lang/String;
    .param p2, "level"    # Lorg/apache/log4j/Priority;
    .param p3, "message"    # Ljava/lang/Object;
    .param p4, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 391
    new-instance v0, Lorg/apache/log4j/spi/LoggingEvent;

    move-object v1, p1

    move-object v2, p0

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lorg/apache/log4j/spi/LoggingEvent;-><init>(Ljava/lang/String;Lorg/apache/log4j/Category;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    invoke-virtual {p0, v0}, Lorg/apache/log4j/Category;->callAppenders(Lorg/apache/log4j/spi/LoggingEvent;)V

    .line 392
    return-void
.end method

.method public declared-synchronized getAllAppenders()Ljava/util/Enumeration;
    .locals 1

    .prologue
    .line 412
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    if-nez v0, :cond_0

    .line 413
    invoke-static {}, Lorg/apache/log4j/helpers/NullEnumeration;->getInstance()Lorg/apache/log4j/helpers/NullEnumeration;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 415
    :goto_0
    monitor-exit p0

    return-object v0

    :cond_0
    :try_start_1
    iget-object v0, p0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    invoke-virtual {v0}, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->getAllAppenders()Ljava/util/Enumeration;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_0

    .line 412
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getEffectiveLevel()Lorg/apache/log4j/Level;
    .locals 2

    .prologue
    .line 442
    move-object v0, p0

    .local v0, "c":Lorg/apache/log4j/Category;
    :goto_0
    if-eqz v0, :cond_1

    .line 443
    iget-object v1, v0, Lorg/apache/log4j/Category;->level:Lorg/apache/log4j/Level;

    if-eqz v1, :cond_0

    .line 444
    iget-object v1, v0, Lorg/apache/log4j/Category;->level:Lorg/apache/log4j/Level;

    .line 446
    :goto_1
    return-object v1

    .line 442
    :cond_0
    iget-object v0, v0, Lorg/apache/log4j/Category;->parent:Lorg/apache/log4j/Category;

    goto :goto_0

    .line 446
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public final getLevel()Lorg/apache/log4j/Level;
    .locals 1

    .prologue
    .line 567
    iget-object v0, p0, Lorg/apache/log4j/Category;->level:Lorg/apache/log4j/Level;

    return-object v0
.end method

.method public getLoggerRepository()Lorg/apache/log4j/spi/LoggerRepository;
    .locals 1

    .prologue
    .line 512
    iget-object v0, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    return-object v0
.end method

.method public final getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 540
    iget-object v0, p0, Lorg/apache/log4j/Category;->name:Ljava/lang/String;

    return-object v0
.end method

.method public isDebugEnabled()Z
    .locals 2

    .prologue
    .line 734
    iget-object v0, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    const/16 v1, 0x2710

    invoke-interface {v0, v1}, Lorg/apache/log4j/spi/LoggerRepository;->isDisabled(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 735
    const/4 v0, 0x0

    .line 736
    :goto_0
    return v0

    :cond_0
    sget-object v0, Lorg/apache/log4j/Level;->DEBUG:Lorg/apache/log4j/Level;

    invoke-virtual {p0}, Lorg/apache/log4j/Category;->getEffectiveLevel()Lorg/apache/log4j/Level;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/log4j/Priority;->isGreaterOrEqual(Lorg/apache/log4j/Priority;)Z

    move-result v0

    goto :goto_0
.end method

.method public isEnabledFor(Lorg/apache/log4j/Priority;)Z
    .locals 2
    .param p1, "level"    # Lorg/apache/log4j/Priority;

    .prologue
    .line 749
    iget-object v0, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    iget v1, p1, Lorg/apache/log4j/Priority;->level:I

    invoke-interface {v0, v1}, Lorg/apache/log4j/spi/LoggerRepository;->isDisabled(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 750
    const/4 v0, 0x0

    .line 751
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lorg/apache/log4j/Category;->getEffectiveLevel()Lorg/apache/log4j/Level;

    move-result-object v0

    invoke-virtual {p1, v0}, Lorg/apache/log4j/Priority;->isGreaterOrEqual(Lorg/apache/log4j/Priority;)Z

    move-result v0

    goto :goto_0
.end method

.method public isInfoEnabled()Z
    .locals 2

    .prologue
    .line 763
    iget-object v0, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    const/16 v1, 0x4e20

    invoke-interface {v0, v1}, Lorg/apache/log4j/spi/LoggerRepository;->isDisabled(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 764
    const/4 v0, 0x0

    .line 765
    :goto_0
    return v0

    :cond_0
    sget-object v0, Lorg/apache/log4j/Level;->INFO:Lorg/apache/log4j/Level;

    invoke-virtual {p0}, Lorg/apache/log4j/Category;->getEffectiveLevel()Lorg/apache/log4j/Level;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/log4j/Priority;->isGreaterOrEqual(Lorg/apache/log4j/Priority;)Z

    move-result v0

    goto :goto_0
.end method

.method public log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "callerFQCN"    # Ljava/lang/String;
    .param p2, "level"    # Lorg/apache/log4j/Priority;
    .param p3, "message"    # Ljava/lang/Object;
    .param p4, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 852
    iget-object v0, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    iget v1, p2, Lorg/apache/log4j/Priority;->level:I

    invoke-interface {v0, v1}, Lorg/apache/log4j/spi/LoggerRepository;->isDisabled(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 858
    :cond_0
    :goto_0
    return-void

    .line 855
    :cond_1
    invoke-virtual {p0}, Lorg/apache/log4j/Category;->getEffectiveLevel()Lorg/apache/log4j/Level;

    move-result-object v0

    invoke-virtual {p2, v0}, Lorg/apache/log4j/Priority;->isGreaterOrEqual(Lorg/apache/log4j/Priority;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 856
    invoke-virtual {p0, p1, p2, p3, p4}, Lorg/apache/log4j/Category;->forcedLog(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public declared-synchronized removeAllAppenders()V
    .locals 3

    .prologue
    .line 886
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    if-eqz v2, :cond_2

    .line 887
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    .line 888
    .local v0, "appenders":Ljava/util/Vector;
    iget-object v2, p0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    invoke-virtual {v2}, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->getAllAppenders()Ljava/util/Enumeration;

    move-result-object v1

    .local v1, "iter":Ljava/util/Enumeration;
    :goto_0
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 889
    invoke-interface {v1}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 886
    .end local v0    # "appenders":Ljava/util/Vector;
    .end local v1    # "iter":Ljava/util/Enumeration;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 891
    .restart local v0    # "appenders":Ljava/util/Vector;
    .restart local v1    # "iter":Ljava/util/Enumeration;
    :cond_0
    :try_start_1
    iget-object v2, p0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;

    invoke-virtual {v2}, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->removeAllAppenders()V

    .line 892
    invoke-virtual {v0}, Ljava/util/Vector;->elements()Ljava/util/Enumeration;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 893
    invoke-interface {v1}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/apache/log4j/Appender;

    invoke-direct {p0, v2}, Lorg/apache/log4j/Category;->fireRemoveAppenderEvent(Lorg/apache/log4j/Appender;)V

    goto :goto_1

    .line 895
    :cond_1
    const/4 v2, 0x0

    iput-object v2, p0, Lorg/apache/log4j/Category;->aai:Lorg/apache/log4j/helpers/AppenderAttachableImpl;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 897
    .end local v0    # "appenders":Ljava/util/Vector;
    .end local v1    # "iter":Ljava/util/Enumeration;
    :cond_2
    monitor-exit p0

    return-void
.end method

.method public setAdditivity(Z)V
    .locals 0
    .param p1, "additive"    # Z

    .prologue
    .line 939
    iput-boolean p1, p0, Lorg/apache/log4j/Category;->additive:Z

    .line 940
    return-void
.end method

.method final setHierarchy(Lorg/apache/log4j/spi/LoggerRepository;)V
    .locals 0
    .param p1, "repository"    # Lorg/apache/log4j/spi/LoggerRepository;

    .prologue
    .line 947
    iput-object p1, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    .line 948
    return-void
.end method

.method public setLevel(Lorg/apache/log4j/Level;)V
    .locals 0
    .param p1, "level"    # Lorg/apache/log4j/Level;

    .prologue
    .line 963
    iput-object p1, p0, Lorg/apache/log4j/Category;->level:Lorg/apache/log4j/Level;

    .line 964
    return-void
.end method

.method public setResourceBundle(Ljava/util/ResourceBundle;)V
    .locals 0
    .param p1, "bundle"    # Ljava/util/ResourceBundle;

    .prologue
    .line 989
    iput-object p1, p0, Lorg/apache/log4j/Category;->resourceBundle:Ljava/util/ResourceBundle;

    .line 990
    return-void
.end method
