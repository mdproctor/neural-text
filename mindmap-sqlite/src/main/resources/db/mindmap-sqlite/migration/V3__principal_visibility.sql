ALTER TABLE mindmap_node ADD COLUMN principal_id TEXT;
ALTER TABLE mindmap_node ADD COLUMN shared_with TEXT;

CREATE INDEX IF NOT EXISTS mindmap_node_principal_idx
    ON mindmap_node (tenant_id, principal_id);
