.class Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;
.super Ljava/lang/Object;
.source "MMSharedPreferences.java"

# interfaces
.implements Landroid/content/SharedPreferences;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;
    }
.end annotation


# instance fields
.field private final columns:[Ljava/lang/String;

.field private final cr:Landroid/content/ContentResolver;

.field private editor:Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;

.field private final values:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string/jumbo v2, "key"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "type"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "value"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->columns:[Ljava/lang/String;

    .line 36
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->values:Ljava/util/HashMap;

    .line 38
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->editor:Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;

    .line 41
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->cr:Landroid/content/ContentResolver;

    .line 42
    return-void
.end method

.method private getValue(Ljava/lang/String;)Ljava/lang/Object;
    .locals 12
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v11, 0x0

    .line 46
    :try_start_0
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->cr:Landroid/content/ContentResolver;

    sget-object v1, Lcom/tencent/mm/sdk/plugin/MMPluginProviderConstants$SharedPref;->CONTENT_URI:Landroid/net/Uri;

    iget-object v2, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->columns:[Ljava/lang/String;

    const-string/jumbo v3, "key = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 48
    .local v6, "cu":Landroid/database/Cursor;
    if-nez v6, :cond_0

    move-object v8, v11

    .line 64
    .end local v6    # "cu":Landroid/database/Cursor;
    :goto_0
    return-object v8

    .line 52
    .restart local v6    # "cu":Landroid/database/Cursor;
    :cond_0
    const-string/jumbo v0, "type"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 53
    .local v9, "typeIdx":I
    const-string/jumbo v0, "value"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v10

    .line 55
    .local v10, "valueIdx":I
    const/4 v8, 0x0

    .line 56
    .local v8, "obj":Ljava/lang/Object;
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 57
    invoke-interface {v6, v9}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-interface {v6, v10}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/tencent/mm/sdk/plugin/MMPluginProviderConstants$Resolver;->resolveObj(ILjava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    .line 59
    .end local v8    # "obj":Ljava/lang/Object;
    :cond_1
    invoke-interface {v6}, Landroid/database/Cursor;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 62
    .end local v6    # "cu":Landroid/database/Cursor;
    .end local v9    # "typeIdx":I
    .end local v10    # "valueIdx":I
    :catch_0
    move-exception v7

    .line 63
    .local v7, "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    move-object v8, v11

    .line 64
    goto :goto_0
.end method


# virtual methods
.method public contains(Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 126
    invoke-direct {p0, p1}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->getValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public edit()Landroid/content/SharedPreferences$Editor;
    .locals 2

    .prologue
    .line 131
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->editor:Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;

    if-nez v0, :cond_0

    .line 132
    new-instance v0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;

    iget-object v1, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->cr:Landroid/content/ContentResolver;

    invoke-direct {v0, v1}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;-><init>(Landroid/content/ContentResolver;)V

    iput-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->editor:Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;

    .line 134
    :cond_0
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->editor:Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;

    return-object v0
.end method

.method public getAll()Ljava/util/Map;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;"
        }
    .end annotation

    .prologue
    const/4 v12, 0x0

    .line 71
    :try_start_0
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->cr:Landroid/content/ContentResolver;

    sget-object v1, Lcom/tencent/mm/sdk/plugin/MMPluginProviderConstants$SharedPref;->CONTENT_URI:Landroid/net/Uri;

    iget-object v2, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->columns:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 73
    .local v6, "cu":Landroid/database/Cursor;
    if-nez v6, :cond_0

    move-object v0, v12

    .line 90
    .end local v6    # "cu":Landroid/database/Cursor;
    :goto_0
    return-object v0

    .line 77
    .restart local v6    # "cu":Landroid/database/Cursor;
    :cond_0
    const-string/jumbo v0, "key"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 78
    .local v8, "keyIdx":I
    const-string/jumbo v0, "type"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v10

    .line 79
    .local v10, "typeIdx":I
    const-string/jumbo v0, "value"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v11

    .line 81
    .local v11, "valueIdx":I
    :goto_1
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 82
    invoke-interface {v6, v10}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-interface {v6, v11}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/tencent/mm/sdk/plugin/MMPluginProviderConstants$Resolver;->resolveObj(ILjava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    .line 83
    .local v9, "obj":Ljava/lang/Object;
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->values:Ljava/util/HashMap;

    invoke-interface {v6, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 88
    .end local v6    # "cu":Landroid/database/Cursor;
    .end local v8    # "keyIdx":I
    .end local v9    # "obj":Ljava/lang/Object;
    .end local v10    # "typeIdx":I
    .end local v11    # "valueIdx":I
    :catch_0
    move-exception v7

    .line 89
    .local v7, "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    .line 90
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->values:Ljava/util/HashMap;

    goto :goto_0

    .line 85
    .end local v7    # "e":Ljava/lang/Exception;
    .restart local v6    # "cu":Landroid/database/Cursor;
    .restart local v8    # "keyIdx":I
    .restart local v10    # "typeIdx":I
    .restart local v11    # "valueIdx":I
    :cond_1
    :try_start_1
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 86
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->values:Ljava/util/HashMap;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method public getBoolean(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defValue"    # Z

    .prologue
    .line 120
    invoke-direct {p0, p1}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->getValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 121
    .local v0, "value":Ljava/lang/Object;
    if-eqz v0, :cond_0

    instance-of v1, v0, Ljava/lang/Boolean;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/Boolean;

    .end local v0    # "value":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p2

    .end local p2    # "defValue":Z
    :cond_0
    return p2
.end method

.method public getFloat(Ljava/lang/String;F)F
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defValue"    # F

    .prologue
    .line 114
    invoke-direct {p0, p1}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->getValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 115
    .local v0, "value":Ljava/lang/Object;
    if-eqz v0, :cond_0

    instance-of v1, v0, Ljava/lang/Float;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/Float;

    .end local v0    # "value":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result p2

    .end local p2    # "defValue":F
    :cond_0
    return p2
.end method

.method public getInt(Ljava/lang/String;I)I
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defValue"    # I

    .prologue
    .line 102
    invoke-direct {p0, p1}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->getValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 103
    .local v0, "value":Ljava/lang/Object;
    if-eqz v0, :cond_0

    instance-of v1, v0, Ljava/lang/Integer;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/Integer;

    .end local v0    # "value":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result p2

    .end local p2    # "defValue":I
    :cond_0
    return p2
.end method

.method public getLong(Ljava/lang/String;J)J
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defValue"    # J

    .prologue
    .line 108
    invoke-direct {p0, p1}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->getValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 109
    .local v0, "value":Ljava/lang/Object;
    if-eqz v0, :cond_0

    instance-of v1, v0, Ljava/lang/Long;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/Long;

    .end local v0    # "value":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide p2

    .end local p2    # "defValue":J
    :cond_0
    return-wide p2
.end method

.method public getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defValue"    # Ljava/lang/String;

    .prologue
    .line 96
    invoke-direct {p0, p1}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->getValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 97
    .local v0, "value":Ljava/lang/Object;
    if-eqz v0, :cond_0

    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/String;

    .end local v0    # "value":Ljava/lang/Object;
    :goto_0
    return-object v0

    .restart local v0    # "value":Ljava/lang/Object;
    :cond_0
    move-object v0, p2

    goto :goto_0
.end method

.method public getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;
    .locals 1
    .param p1, "arg0"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 250
    .local p2, "arg1":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .prologue
    .line 141
    return-void
.end method

.method public unregisterOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .prologue
    .line 147
    return-void
.end method
