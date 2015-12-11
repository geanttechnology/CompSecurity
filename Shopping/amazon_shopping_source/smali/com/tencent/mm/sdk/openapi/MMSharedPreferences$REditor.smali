.class Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;
.super Ljava/lang/Object;
.source "MMSharedPreferences.java"

# interfaces
.implements Landroid/content/SharedPreferences$Editor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "REditor"
.end annotation


# instance fields
.field private clear:Z

.field private cr:Landroid/content/ContentResolver;

.field private remove:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private values:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/ContentResolver;)V
    .locals 1
    .param p1, "cr"    # Landroid/content/ContentResolver;

    .prologue
    .line 156
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 151
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->values:Ljava/util/Map;

    .line 152
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->remove:Ljava/util/Set;

    .line 153
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->clear:Z

    .line 157
    iput-object p1, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->cr:Landroid/content/ContentResolver;

    .line 158
    return-void
.end method


# virtual methods
.method public apply()V
    .locals 0

    .prologue
    .line 238
    return-void
.end method

.method public clear()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 203
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->clear:Z

    .line 204
    return-object p0
.end method

.method public commit()Z
    .locals 12

    .prologue
    const/4 v7, 0x0

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 210
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 213
    .local v3, "kv":Landroid/content/ContentValues;
    iget-boolean v5, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->clear:Z

    if-eqz v5, :cond_0

    .line 214
    iget-object v5, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->cr:Landroid/content/ContentResolver;

    sget-object v6, Lcom/tencent/mm/sdk/plugin/MMPluginProviderConstants$SharedPref;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v5, v6, v7, v7}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 215
    iput-boolean v10, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->clear:Z

    .line 219
    :cond_0
    iget-object v5, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->remove:Ljava/util/Set;

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 220
    .local v2, "key":Ljava/lang/String;
    iget-object v5, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->cr:Landroid/content/ContentResolver;

    sget-object v6, Lcom/tencent/mm/sdk/plugin/MMPluginProviderConstants$SharedPref;->CONTENT_URI:Landroid/net/Uri;

    const-string/jumbo v7, "key = ?"

    new-array v8, v11, [Ljava/lang/String;

    aput-object v2, v8, v10

    invoke-virtual {v5, v6, v7, v8}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0

    .line 224
    .end local v2    # "key":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->values:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    .line 225
    .local v4, "sets":Ljava/util/Set;, "Ljava/util/Set<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 226
    .local v0, "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    invoke-static {v3, v5}, Lcom/tencent/mm/sdk/plugin/MMPluginProviderConstants$Resolver;->unresolveObj(Landroid/content/ContentValues;Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 227
    iget-object v6, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->cr:Landroid/content/ContentResolver;

    sget-object v7, Lcom/tencent/mm/sdk/plugin/MMPluginProviderConstants$SharedPref;->CONTENT_URI:Landroid/net/Uri;

    const-string/jumbo v8, "key = ?"

    new-array v9, v11, [Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    aput-object v5, v9, v10

    invoke-virtual {v6, v7, v3, v8, v9}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_1

    .line 231
    .end local v0    # "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_3
    return v11
.end method

.method public putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 190
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->values:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 191
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->remove:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 192
    return-object p0
.end method

.method public putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # F

    .prologue
    .line 183
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->values:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 184
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->remove:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 185
    return-object p0
.end method

.method public putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 169
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->values:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 170
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->remove:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 171
    return-object p0
.end method

.method public putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # J

    .prologue
    .line 176
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->values:Ljava/util/Map;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->remove:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 178
    return-object p0
.end method

.method public putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 162
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->values:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->remove:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 164
    return-object p0
.end method

.method public putStringSet(Ljava/lang/String;Ljava/util/Set;)Landroid/content/SharedPreferences$Editor;
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
            "Landroid/content/SharedPreferences$Editor;"
        }
    .end annotation

    .prologue
    .line 243
    .local p2, "arg1":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 197
    iget-object v0, p0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences$REditor;->remove:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 198
    return-object p0
.end method
