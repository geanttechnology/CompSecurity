.class public Lcom/amazon/identity/auth/device/framework/SQLTable;
.super Ljava/lang/Object;
.source "SQLTable.java"


# instance fields
.field private mColumnNames:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mName:Ljava/lang/String;

.field private mTableDefinition:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/SQLTable;)V
    .locals 2
    .param p1, "table"    # Lcom/amazon/identity/auth/device/framework/SQLTable;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mColumnNames:Ljava/util/List;

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mTableDefinition:Ljava/util/List;

    .line 22
    iget-object v0, p1, Lcom/amazon/identity/auth/device/framework/SQLTable;->mName:Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mName:Ljava/lang/String;

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p1, Lcom/amazon/identity/auth/device/framework/SQLTable;->mColumnNames:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mColumnNames:Ljava/util/List;

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p1, Lcom/amazon/identity/auth/device/framework/SQLTable;->mTableDefinition:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mTableDefinition:Ljava/util/List;

    .line 25
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mColumnNames:Ljava/util/List;

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mTableDefinition:Ljava/util/List;

    .line 17
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mName:Ljava/lang/String;

    .line 18
    return-void
.end method


# virtual methods
.method public addColumn(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mColumnNames:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 40
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mTableDefinition:Ljava/util/List;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 41
    return-object p0
.end method

.method public addConstraint(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/SQLTable;
    .locals 1
    .param p1, "constraint"    # Ljava/lang/String;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mTableDefinition:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 47
    return-object p0
.end method

.method public getColumnNames()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mColumnNames:Ljava/util/List;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mName:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 58
    const-string/jumbo v0, "CREATE TABLE %s (%s);"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mName:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string/jumbo v3, ", "

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/SQLTable;->mTableDefinition:Ljava/util/List;

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/StringHelpers;->join(Ljava/lang/String;Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
